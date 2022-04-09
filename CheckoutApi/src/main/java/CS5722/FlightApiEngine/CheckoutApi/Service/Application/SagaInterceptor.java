package CS5722.FlightApiEngine.CheckoutApi.Service.Application;

import CS5722.FlightApiEngine.CheckoutApi.Framework.Dispatcher.InterceptorManagerDispatcher;
import CS5722.FlightApiEngine.CheckoutApi.Framework.Interceptor.IInterceptor;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Price;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Segment;
import CS5722.FlightApiEngine.CheckoutApi.Service.BookingStatusPublisher;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.BookingRequest;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.CurrencyCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@Component
@Qualifier("sagaInterceptor")
public class SagaInterceptor implements IInterceptor {

    private final BookingStatusPublisher bookingStatusPublisher;

    private final ModelMapper modelMapper;

    private final InterceptorManagerDispatcher interceptorManagerDispatcher;

    public SagaInterceptor ( BookingStatusPublisher bookingStatusPublisher,ModelMapper modelMapper,InterceptorManagerDispatcher interceptorManager ) {
        this.bookingStatusPublisher = bookingStatusPublisher;
        this.modelMapper = modelMapper;
        this.interceptorManagerDispatcher = interceptorManager;
    }

    @PostConstruct
    public void registerInterceptorWithDispatcher () {
        this.interceptorManagerDispatcher.attachInterceptor(this);
    }

    @Override
    public void doTask ( Booking booking ) {
        // We can access context object - booking internals and methods
        var bookingRequest = new BookingRequest();
        bookingRequest.setBookingId(booking.getBookingId());
        var totalPrice = booking.getItinerary().getJourneys().stream().flatMap(f -> f.getSegments().stream()).collect(Collectors.toList()).stream().map(Segment::getPrice).collect(Collectors.toList()).stream().mapToDouble(Price::getAmount).sum();
        bookingRequest.setAmount(totalPrice);
        bookingRequest.setCurrencyCode(modelMapper.map(booking.getCurrencyCode(),CurrencyCode.class));
        bookingRequest.setPaymentInformation(modelMapper.map(booking.getPaymentInformation(),CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.PaymentInformation.class));
        bookingRequest.setEmail(booking.getContactInformation().getEmail());
        bookingStatusPublisher.publishBookingEvent(bookingRequest,CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.BookingStatus.Pending);
    }
}

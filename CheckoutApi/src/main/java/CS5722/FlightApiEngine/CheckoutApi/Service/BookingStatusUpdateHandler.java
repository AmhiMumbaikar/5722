package CS5722.FlightApiEngine.CheckoutApi.Service;

import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.IBookingRepository;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.BookingStatus;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.PaymentRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookingStatusUpdateHandler {

    private final IBookingRepository bookingRepository;

    private final ModelMapper modelMapper;

    public BookingStatusUpdateHandler ( IBookingRepository bookingResponseRepository,ModelMapper modelMapper ) {
        this.bookingRepository = bookingResponseRepository;
        this.modelMapper = modelMapper;
    }

    public void updateBooking ( PaymentRequest paymentRequest,BookingStatus bookingStatus ) {

        var bookingOptional = bookingRepository.findById(paymentRequest.getBookingId());

        if (bookingOptional.isPresent()) {

            var booking = bookingOptional.get();

            booking.setBookingStatus(modelMapper.map(bookingStatus,CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.BookingStatus.class));

            // Only booked will have locator generated
            if (bookingStatus == BookingStatus.Booked) {
                booking.setLocator("TESTBK" + String.format("%04d",new Random().nextInt(999999)));
            }

            bookingRepository.save(booking);
        }
    }
}

package CS5722.FlightApiEngine.CheckoutApi.Service;

import CS5722.FlightApiEngine.CheckoutApi.Service.Event.BookingEvent;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.BookingRequest;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.BookingStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
@Slf4j
public class BookingStatusPublisher {

    private final Sinks.Many<BookingEvent> bookingEvents;

    public BookingStatusPublisher ( Sinks.Many<BookingEvent> bookingEvents ) {
        this.bookingEvents = bookingEvents;
    }

    public void publishBookingEvent ( BookingRequest bookingRequest,BookingStatus bookingStatus ) {
        var bookingEvent = new BookingEvent(bookingRequest,bookingStatus);
        log.info(String.valueOf(bookingEvent));
        bookingEvents.tryEmitNext(bookingEvent);
    }
}

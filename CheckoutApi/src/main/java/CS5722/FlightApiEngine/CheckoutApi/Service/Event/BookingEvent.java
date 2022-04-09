package CS5722.FlightApiEngine.CheckoutApi.Service.Event;

import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.BookingRequest;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity.BookingStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class BookingEvent implements Event{

    private UUID eventId = UUID.randomUUID();
    private Date eventDate = new Date();
    private BookingRequest bookingRequest;
    private BookingStatus bookingStatus;

    public BookingEvent ( BookingRequest bookingRequest,BookingStatus bookingStatus ) {
        this.bookingRequest = bookingRequest;
        this.bookingStatus = bookingStatus;
    }

    @Override
    public UUID getEventId()
    {
        return this.eventId;
    }

    @Override
    public Date getDate () {
        return this.getEventDate();
    }
}


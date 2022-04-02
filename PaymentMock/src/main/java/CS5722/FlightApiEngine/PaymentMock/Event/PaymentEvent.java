package CS5722.FlightApiEngine.PaymentMock.Event;

import CS5722.FlightApiEngine.PaymentMock.Event.Entity.BookingStatus;
import CS5722.FlightApiEngine.PaymentMock.Event.Entity.PaymentRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class PaymentEvent implements Event {

    private UUID eventId = UUID.randomUUID();
    private Date eventDate = new Date();
    private PaymentRequest paymentRequest;
    private BookingStatus bookingStatus;

    public PaymentEvent ( PaymentRequest paymentRequest,BookingStatus bookingStatus ) {
        this.paymentRequest = paymentRequest;
        this.bookingStatus = bookingStatus;
    }

    @Override
    public UUID getEventId () {
        return this.eventId;
    }

    @Override
    public Date getDate () {
        return this.getEventDate();
    }
}

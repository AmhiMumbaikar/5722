package CS5722.FlightApiEngine.CheckoutApi.Service.Event;

import java.util.Date;
import java.util.UUID;

public interface Event {

    UUID getEventId();

    Date getDate();
}
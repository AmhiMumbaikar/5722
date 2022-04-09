package CS5722.FlightApiEngine.CheckoutApi.Controller.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutResponse
{
    private String bookingId;

    private BookingStatus bookingStatus;
}

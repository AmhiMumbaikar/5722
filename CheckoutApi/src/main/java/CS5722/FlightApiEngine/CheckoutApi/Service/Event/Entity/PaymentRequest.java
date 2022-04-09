package CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Payment request is like what was requested to payment service
public class PaymentRequest {
    private String bookingId;

    // We might want to record errors here or other parameters as well.
}

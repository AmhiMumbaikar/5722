package CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private String email;

    private String bookingId;

    private double amount;

    private CurrencyCode currencyCode;

    private PaymentInformation paymentInformation;
}
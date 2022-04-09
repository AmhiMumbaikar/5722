package CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity;

import CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private String email;

    private Integer bookingId;

    private double amount;

    private CurrencyCode currencyCode;

    private PaymentInformation paymentInformation;
}

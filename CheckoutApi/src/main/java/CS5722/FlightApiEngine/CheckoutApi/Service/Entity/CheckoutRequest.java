package CS5722.FlightApiEngine.CheckoutApi.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutRequest
{
    private String availabilityId;

    private ContactInformation contactInformation;

    private PaymentInformation paymentInformation;

    private CurrencyCode currencyCode;
}
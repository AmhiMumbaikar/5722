package CS5722.FlightApiEngine.CheckoutApi.Controller.Entity;

import CS5722.FlightApiEngine.CheckoutApi.Validator.ValidAvailabilityId;
import CS5722.FlightApiEngine.CheckoutApi.Validator.ValidContactInformation;
import CS5722.FlightApiEngine.CheckoutApi.Validator.ValidCurrencyCode;
import CS5722.FlightApiEngine.CheckoutApi.Validator.ValidPaymentInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutRequest
{
    @ValidAvailabilityId(propName = "availabilityId", additionalMessage = "Invalid or Expired")
    private String availabilityId;

    @ValidContactInformation
    private ContactInformation contactInformation;

    @ValidPaymentInformation
    private PaymentInformation paymentInformation;

    @ValidCurrencyCode
    private CurrencyCode currencyCode;
}
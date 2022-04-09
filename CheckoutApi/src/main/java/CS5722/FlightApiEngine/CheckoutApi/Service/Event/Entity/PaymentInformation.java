package CS5722.FlightApiEngine.CheckoutApi.Service.Event.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInformation
{
    private String cardType;

    private String cardNumber;

    private String cardHolderName;

    private int expiryMonth;

    private int expiryYear;

    private int cvv;
}

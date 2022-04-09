package CS5722.FlightApiEngine.CheckoutApi.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInformation
{
    // Make it enum
    private String cardType;

    private String cardHolderName;

    private String cardNumber;

    private int expiryMonth;

    private int expiryYear;

    private int cvv;
}

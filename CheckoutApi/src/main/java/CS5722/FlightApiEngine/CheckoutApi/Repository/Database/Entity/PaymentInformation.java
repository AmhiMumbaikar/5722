package CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentInformation {

    @Id
    private String paymentId;

    // Make it enum
    private String cardType;

    private String cardHolderName;

    private String cardNumber;

    private int expiryMonth;

    private int expiryYear;

    private int cvv;
}

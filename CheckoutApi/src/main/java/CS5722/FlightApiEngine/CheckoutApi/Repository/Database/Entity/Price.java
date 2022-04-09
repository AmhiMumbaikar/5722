package CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Price {

    @Id
    private String priceId;

    private double amount;

    @Enumerated(EnumType.STRING)
    public CurrencyCode currencyCode;
}

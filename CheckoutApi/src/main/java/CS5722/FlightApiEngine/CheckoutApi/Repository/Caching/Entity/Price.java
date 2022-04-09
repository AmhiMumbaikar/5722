package CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price{

    private String priceId;

    private double amount;

    private CurrencyCode currencyCode;
}

package CS5722.FlightApiEngine.SearchApi.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private String priceId;

    private double amount; // Per passenger Price - Business scenario

    private CurrencyCode currencyCode;
}
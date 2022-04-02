package CS5722.FlightApiEngine.AvailabilityApi.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties("credit-cards-config")
public class CreditCardsConfig {
    private List<Map<String, String>> validCreditCards;
}

package CS5722.FlightApiEngine.SearchApi.Config;

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
@ConfigurationProperties("airport-codes-config")
public class AirportCodesConfig {
    private List<String> validAirportCodes;
    private Map<String, List<String>> nearbyAirportCodes;
    private NearbyAirportCodesSwitch nearbyAirportCodesSwitch;
}

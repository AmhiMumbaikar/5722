package CS5722.FlightApiEngine.SearchApi.Service.Adapter;

import CS5722.FlightApiEngine.SearchApi.Config.AirportCodesConfig;
import CS5722.FlightApiEngine.SearchApi.Config.NearbyAirportCodesSwitch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// We can implement adaptee or send an implementation of functional interface INearbyAirportCodesAdaptee
@Component
public class NearbyAirportCodesAdapter implements INearbyAirportCodesAdapter {

    private final AirportCodesConfig airportCodesConfig;

    public NearbyAirportCodesAdapter ( AirportCodesConfig airportCodesConfig ) {
        this.airportCodesConfig = airportCodesConfig;
    }

    @Override
    public List<String> getAllNearbyAirportCodes ( String code ) {

        var nearbyAirportCodes = airportCodesConfig.getNearbyAirportCodes();

        var nearbyAirportCodesSwitch = airportCodesConfig.getNearbyAirportCodesSwitch();

        return getINearbyAirportCodesAdapteeImplementation(nearbyAirportCodesSwitch,nearbyAirportCodes).getNearbyAirportCodes(code);

    }

    private INearbyAirportCodesAdaptee getINearbyAirportCodesAdapteeImplementation ( NearbyAirportCodesSwitch nearbyAirportCodesSwitch,Map<String, List<String>> nearbyAirportCodesMap ) {

        switch (nearbyAirportCodesSwitch) {
            case On: {
                var nearByAirportCodes = new ArrayList<String>();
                return ( String code ) -> {
                    if (nearbyAirportCodesMap.containsKey(code)) {
                        nearByAirportCodes.addAll(nearbyAirportCodesMap.get(code));
                    }
                    nearByAirportCodes.add(code);
                    return nearByAirportCodes;
                };
            }
            case Off: {
                return List::of;
            }
            default:
                throw new UnsupportedOperationException("Invalid NearbyAirportCodesSwitch");
        }
    }
}

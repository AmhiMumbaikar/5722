package CS5722.FlightApiEngine.SearchApi.Service.Adapter;

import java.util.List;

@FunctionalInterface
public interface INearbyAirportCodesAdaptee {

    List<String> getNearbyAirportCodes ( String code );
}

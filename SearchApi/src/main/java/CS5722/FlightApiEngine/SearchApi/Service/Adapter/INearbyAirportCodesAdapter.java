package CS5722.FlightApiEngine.SearchApi.Service.Adapter;

import java.util.List;

public interface INearbyAirportCodesAdapter {
    List<String> getAllNearbyAirportCodes ( String code );
}

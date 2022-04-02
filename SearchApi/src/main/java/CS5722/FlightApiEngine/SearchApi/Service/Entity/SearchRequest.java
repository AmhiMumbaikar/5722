package CS5722.FlightApiEngine.SearchApi.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
    private String fromCode;

    private String toCode;

    private String fromDate;

    private String toDate;

    private TripType tripType;

    private int paxCount;

    private boolean includeNearbyAirports;
}

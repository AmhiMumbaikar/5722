package CS5722.FlightApiEngine.SearchApi.controller.Entity;

import CS5722.FlightApiEngine.SearchApi.Validator.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest
{
    @ValidAirportCode(propName = "fromCode")
    private String fromCode;

    @ValidAirportCode(propName = "toCode")
    private String toCode;

    @ValidDate(propName = "fromDate", nullable = false)
    private String fromDate;

    @ValidDate(propName = "toDate", nullable = true)
    private String toDate;

    private TripType tripType;

    @ValidPaxCount
    private int paxCount;

    private boolean includeNearbyAirports;
}

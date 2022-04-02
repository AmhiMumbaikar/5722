package CS5722.FlightApiEngine.AvailabilityApi.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityResponse {

    private String availabilityId;

    private Itinerary itinerary;

    private AvailabilityStatus availabilityStatus;

    private List<Map<String, String>> validCreditCards;
}
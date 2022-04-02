package CS5722.FlightApiEngine.SearchApi.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Itinerary {
    private String itineraryId;

    private List<Journey> journeys;
}
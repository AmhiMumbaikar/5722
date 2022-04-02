package CS5722.FlightApiEngine.SearchApi.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Journey {

    private String journeyId;

    private Way way;

    private int duration; // In minutes

    private List<Segment> segments;
}
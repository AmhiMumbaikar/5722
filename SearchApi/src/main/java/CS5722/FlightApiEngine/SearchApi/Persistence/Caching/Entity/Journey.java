package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Composite.ISScoreDeduceComponent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
// LEAF IN COMPOSITE DESIGN PATTERN
public class Journey implements ISScoreDeduceComponent {

    private String journeyId;

    private Way way;

    private int duration; // In minutes

    private List<Segment> segments;

    // For composite pattern
    // 0-1 score value
    @Override
    public double deduceScore () {
        return this.segments.stream().mapToDouble(Segment::getScore).average().orElse(0);
    }
}
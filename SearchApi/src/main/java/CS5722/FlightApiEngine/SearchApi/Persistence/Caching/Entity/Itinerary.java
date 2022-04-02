package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Composite.ISScoreDeduceComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "Itinerary", timeToLive = 60)

//COMPOSITE IN COMPOSITE DESIGN PATTERN
public class Itinerary implements ISScoreDeduceComponent {

    @Id
    @AccessType(AccessType.Type.PROPERTY)
    private String itineraryId;

    private List<ISScoreDeduceComponent> journeys;

    // For composite pattern
    @Transient
    private double score;

    @Override
    public double deduceScore () {
        return this.journeys.stream().mapToDouble(ISScoreDeduceComponent::deduceScore).average().orElse(0);
    }
}
package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Itinerary")
public class Itinerary {

    @Id
    @AccessType(AccessType.Type.PROPERTY)
    private String itineraryId;

    private double score;

    private List<Journey> journeys;
}
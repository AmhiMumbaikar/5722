package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@RedisHash(value = "Availability", timeToLive = 600)
public class AvailabilityResponse {

    @Id
    @AccessType(AccessType.Type.PROPERTY)
    private String availabilityId;

    private Itinerary itinerary;

    private AvailabilityStatus availabilityStatus;

    private List<Map<String, String>> validCreditCards;
}
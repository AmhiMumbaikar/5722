package CS5722.FlightApiEngine.AvailabilityApi.Controller.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "Availability", timeToLive = 60)
public class AvailabilityResponse {

    @Id
    @AccessType(AccessType.Type.PROPERTY)
    private String availabilityId;

    private Itinerary itinerary;

    private AvailabilityStatus availabilityStatus;

    private List<Map<String, String>> validCreditCards;
}
package CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "Availability")
public class AvailabilityResponse {

    @Id
    @AccessType(AccessType.Type.PROPERTY)
    private String availabilityId;

    private Itinerary itinerary;

    private AvailabilityStatus availabilityStatus;
}
package CS5722.FlightApiEngine.AvailabilityApi.Controller.Entity;

import CS5722.FlightApiEngine.AvailabilityApi.Validator.ValidItineraryId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityRequest {

    @ValidItineraryId(propName = "itineraryId", additionalMessage = "Invalid or Expired")
    private String itineraryId;
}

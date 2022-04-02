package CS5722.FlightApiEngine.AvailabilityApi.Service;

import CS5722.FlightApiEngine.AvailabilityApi.Service.Entity.AvailabilityRequest;
import CS5722.FlightApiEngine.AvailabilityApi.Service.Entity.AvailabilityResponse;

public interface IAvailabilityService {
    AvailabilityResponse checkAvailability ( AvailabilityRequest request );
}

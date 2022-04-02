package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Director;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityResponse;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary;

public interface IAvailabilityResponseBuilderDirector {

    AvailabilityResponse buildAvailabilityResponse ( Itinerary searchItinerary );
}

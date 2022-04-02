package CS5722.FlightApiEngine.AvailabilityApi.Repository.Strategy;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityStatus;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary;

// The strategy is based on meta providers who can book one leg/segment with others
public interface IAvailabilityStatusStrategy {

    AvailabilityStatus deduceAvailabilityStatus ( Itinerary searchItinerary );
}

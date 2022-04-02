package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItineraryRepository extends CrudRepository<Itinerary, String> {
}

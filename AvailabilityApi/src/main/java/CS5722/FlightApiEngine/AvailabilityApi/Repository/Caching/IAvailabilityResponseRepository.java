package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvailabilityResponseRepository extends CrudRepository<AvailabilityResponse, String> {

}
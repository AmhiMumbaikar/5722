package CS5722.FlightApiEngine.CheckoutApi.Repository.Caching;

import CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity.AvailabilityResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvailabilityResponseRepository extends CrudRepository<AvailabilityResponse, String> {
}
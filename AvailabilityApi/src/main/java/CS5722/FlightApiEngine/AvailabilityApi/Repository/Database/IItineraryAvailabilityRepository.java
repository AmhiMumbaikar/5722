package CS5722.FlightApiEngine.AvailabilityApi.Repository.Database;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Database.Entity.TicketAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItineraryAvailabilityRepository extends JpaRepository<TicketAvailability, String> {

}
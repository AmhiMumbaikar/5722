package CS5722.FlightApiEngine.SearchApi.Persistence.Database;

import CS5722.FlightApiEngine.SearchApi.Persistence.Database.Entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISegmentRepository extends JpaRepository<Segment, String> {

    List<Segment> findByDepartureCodeAndDepartureDateAndArrivalCodeAndArrivalDate ( String departureCode,
                                                                                    String departureDate,
                                                                                    String arrivalCode,
                                                                                    String arrivalDate );
}
package CS5722.FlightApiEngine.BookingsApi.Repository;

import CS5722.FlightApiEngine.BookingsApi.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, String> {
}


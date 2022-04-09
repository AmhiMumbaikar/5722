package CS5722.FlightApiEngine.CheckoutApi.Repository.Database;

import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, String> {
}


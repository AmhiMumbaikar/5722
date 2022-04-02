package CS5722.FlightApiEngine.AvailabilityApi.Repository.Database.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketAvailability {

    @Id
    public String segmentId;

    @Enumerated(EnumType.STRING)
    public AvailabilityStatus availabilityStatus;
}

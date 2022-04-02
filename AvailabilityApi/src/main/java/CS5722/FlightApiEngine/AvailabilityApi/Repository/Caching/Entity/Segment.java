package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Segment{

    private String segmentId;

    private int flightNo;

    private int durationInMinutes;

    private TravelClass travelClass;

    private int waitingTimeInMinutes;

    private String departureCode;

    private String departureDate;

    private String arrivalCode;

    private String arrivalDate;

    private Price price;

    @Transient
    private AvailabilityStatus availabilityStatus;
}

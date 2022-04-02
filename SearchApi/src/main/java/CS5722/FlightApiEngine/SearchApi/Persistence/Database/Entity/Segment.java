package CS5722.FlightApiEngine.SearchApi.Persistence.Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Segment{

    @Id
    private String segmentId;

    private int flightNo;

    private int durationInMinutes;

    @Enumerated(EnumType.STRING)
    private TravelClass travelClass;

    private int waitingTimeInMinutes;

    private String departureCode;

    private String departureDate;

    private String arrivalCode;

    private String arrivalDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priceId")
    private Price price;

    // Composite pattern
    private double score;
}
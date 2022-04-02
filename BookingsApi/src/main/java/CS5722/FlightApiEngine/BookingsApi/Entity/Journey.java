package CS5722.FlightApiEngine.BookingsApi.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Journey{

    @Id
    private String journeyId;

    @Enumerated(EnumType.STRING)
    private Way way;

    private int duration; // In minutes

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Segment> segments;
}

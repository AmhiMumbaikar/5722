package CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Segment> segments = new HashSet<>();
}

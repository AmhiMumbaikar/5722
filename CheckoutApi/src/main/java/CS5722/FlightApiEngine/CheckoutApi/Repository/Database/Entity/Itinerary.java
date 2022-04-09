package CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Itinerary{

    @Id
    private String itineraryId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Journey> journeys = new HashSet<>();
}
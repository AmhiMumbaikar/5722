package CS5722.FlightApiEngine.BookingsApi.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContactInformation
{
    @Id
    private String contactId;

    private String email;

    private String phoneNumber;
}

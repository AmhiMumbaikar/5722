package CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity;

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

    public String email;

    public String phoneNumber;
}

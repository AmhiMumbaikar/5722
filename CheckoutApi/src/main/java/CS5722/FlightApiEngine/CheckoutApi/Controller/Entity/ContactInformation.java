package CS5722.FlightApiEngine.CheckoutApi.Controller.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformation
{
    private String email;

    private String phoneNumber;
}

package CS5722.FlightApiEngine.BookingsApi.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking
{
    @Id
    private String bookingId;

    private String locator;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itineraryId")
    private Itinerary itinerary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactInformationId")
    private ContactInformation contactInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentInformationId")
    private PaymentInformation paymentInformation;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode;
}

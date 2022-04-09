package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Builder;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityResponse;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityStatus;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AvailabilityResponseBuilder implements IAvailabilityResponseBuilder {
    private String availabilityId;

    private Itinerary itinerary;

    private AvailabilityStatus availabilityStatus;

    private List<Map<String, String>> validCreditCards;

    @Override
    public void setAvailabilityId ( String availabilityId ) {
        this.availabilityId = availabilityId;
    }

    @Override
    public void setItinerary ( Itinerary itinerary ) {
        this.itinerary = itinerary;
    }

    @Override
    public void setAvailabilityStatus ( AvailabilityStatus availabilityStatus ) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public void setValidCreditCards ( List<Map<String, String>> validCreditCards ) {
        this.validCreditCards = validCreditCards;
    }

    @Override
    public AvailabilityResponse getAvailabilityResponse () {
        return new AvailabilityResponse(this.availabilityId,this.itinerary,this.availabilityStatus,
                this.validCreditCards);
    }
}

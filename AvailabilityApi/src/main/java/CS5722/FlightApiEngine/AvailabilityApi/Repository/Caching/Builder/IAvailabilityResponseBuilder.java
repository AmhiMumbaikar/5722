package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Builder;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityResponse;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityStatus;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary;

import java.util.List;
import java.util.Map;

public interface IAvailabilityResponseBuilder {
    void setAvailabilityId ( String availabilityId );

    void setItinerary ( Itinerary itinerary );

    void setAvailabilityStatus ( AvailabilityStatus availabilityStatus );

    void setValidCreditCards ( List<Map<String, String>> validCreditCards );

    AvailabilityResponse getAvailabilityResponse ();
}

package CS5722.FlightApiEngine.SearchApi.Persistence.Caching;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Composite.ISScoreDeduceComponent;

import java.util.List;
import java.util.UUID;

public class ItineraryBuilderDirector {
    public static CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Itinerary getItinerary ( List<ISScoreDeduceComponent> outJourneys ) {

        var itinerary = new CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Itinerary();
        itinerary.setItineraryId(UUID.randomUUID().toString());
        itinerary.setJourneys(outJourneys);
        return itinerary;
    }
}

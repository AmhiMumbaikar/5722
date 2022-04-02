package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Command;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Itinerary;

import java.util.List;

public interface IItineraryDevelopmentCommand {

    List<Itinerary> execute (
            List<String> allDepartureCodes,List<String> allArrivalCodes,String fromDate,String toDate
    );
}

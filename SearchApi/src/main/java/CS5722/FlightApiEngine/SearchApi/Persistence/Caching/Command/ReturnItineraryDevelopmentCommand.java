package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Command;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Itinerary;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.CommandReceivers.ReturnItineraryDevelopmentCommandReceiver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("returnItineraryDevelopmentCommand")
public class ReturnItineraryDevelopmentCommand implements IItineraryDevelopmentCommand {
    private final ReturnItineraryDevelopmentCommandReceiver returnItineraryDevelopmentCommandReceiver;

    public ReturnItineraryDevelopmentCommand ( ReturnItineraryDevelopmentCommandReceiver returnItineraryDevelopmentCommandReceiver ) {
        this.returnItineraryDevelopmentCommandReceiver = returnItineraryDevelopmentCommandReceiver;
    }

    @Override
    public List<Itinerary> execute (
            List<String> allDepartureCodes,List<String> allArrivalCodes,String fromDate,String toDate
    ) {
        return returnItineraryDevelopmentCommandReceiver.getReturnItineraries(allDepartureCodes,allArrivalCodes,
                fromDate,toDate);
    }
}

package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Command;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Itinerary;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.CommandReceivers.OneWayItineraryDevelopmentCommandReceiver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("oneWayItineraryDevelopmentCommand")
public class OneWayItineraryDevelopmentCommand implements IItineraryDevelopmentCommand {

    private final OneWayItineraryDevelopmentCommandReceiver oneWayItineraryCommandReceiver;

    public OneWayItineraryDevelopmentCommand ( OneWayItineraryDevelopmentCommandReceiver oneWayItineraryCommandReceiver ) {
        this.oneWayItineraryCommandReceiver = oneWayItineraryCommandReceiver;
    }

    @Override
    public List<Itinerary> execute (
            List<String> allDepartureCodes,List<String> allArrivalCodes,String fromDate,String toDate
    ) {
        return oneWayItineraryCommandReceiver.getOnewayItineraries(allDepartureCodes,allArrivalCodes,fromDate,toDate);
    }
}

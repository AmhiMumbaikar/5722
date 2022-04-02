package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.CommandReceivers;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Builder.DirectJourneyBuilder;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Director.JourneyBuilderDirector;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Itinerary;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Template.SegmentsGenerator;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.IItineraryRepository;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.ItineraryBuilderDirector;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.Way;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OneWayItineraryDevelopmentCommandReceiver {

    private final SegmentsGenerator segmentsGenerator;

    private final JourneyBuilderDirector journeyBuilderDirector;

    private final IItineraryRepository itineraryRepository;

    public OneWayItineraryDevelopmentCommandReceiver (
            SegmentsGenerator segmentsGenerator,JourneyBuilderDirector journeyBuilderDirector,IItineraryRepository itineraryRepository
    ) {
        this.segmentsGenerator = segmentsGenerator;
        this.journeyBuilderDirector = journeyBuilderDirector;
        this.itineraryRepository = itineraryRepository;
    }

    @SuppressWarnings("unused")
    public ArrayList<Itinerary> getOnewayItineraries (
            List<String> allDepartureCodes,List<String> allArrivalCodes,String fromDate,String toDate
    ) {
        var itineraries = new ArrayList<Itinerary>();

        // log(n^2) time complexity :(
        var outSegments = segmentsGenerator.generateSegments(allDepartureCodes,allArrivalCodes,fromDate,fromDate);

        // build journey
        var outboundDirectJourneyBuilder = new DirectJourneyBuilder();

        for (var outSegment : outSegments) {
            var outJourney = journeyBuilderDirector.getDirectJourney(outboundDirectJourneyBuilder,Way.Out,outSegment);

            // 0.25 is magic number to exclude the itinerary
            // Please note it's a bad code but shall be improved to take input from client

            if (outJourney.deduceScore() <= 0.25) {
                continue;
            }

            var oneWayItinerary = ItineraryBuilderDirector.getItinerary(List.of(outJourney));

            // 0.25 is magic number to exclude the itinerary
            if (oneWayItinerary.deduceScore() <= 0.25) {
                continue;
            }

            itineraryRepository.save(oneWayItinerary);
            itineraries.add(oneWayItinerary);
        }

        return itineraries;
    }
}

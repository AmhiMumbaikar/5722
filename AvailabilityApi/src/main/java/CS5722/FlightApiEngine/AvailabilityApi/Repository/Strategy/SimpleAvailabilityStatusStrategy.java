package CS5722.FlightApiEngine.AvailabilityApi.Repository.Strategy;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityStatus;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Segment;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Database.IItineraryAvailabilityRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Qualifier("simpleAvailabilityStatusStrategy")
public class SimpleAvailabilityStatusStrategy implements IAvailabilityStatusStrategy {

    private final IItineraryAvailabilityRepository itineraryAvailabilityRepository;

    public SimpleAvailabilityStatusStrategy ( IItineraryAvailabilityRepository itineraryAvailabilityRepository ) {
        this.itineraryAvailabilityRepository = itineraryAvailabilityRepository;
    }

    @Override
    public AvailabilityStatus deduceAvailabilityStatus ( Itinerary searchItinerary ) {

        var availabilityStatus = AvailabilityStatus.Available;

        var segmentIds = searchItinerary.getJourneys().stream().flatMap(x -> x.getSegments().stream()).map(Segment::getSegmentId).collect(Collectors.toList());

        for (var segmentId : segmentIds) {
            var itineraryAvailabilitiesOptional = itineraryAvailabilityRepository.findById(segmentId);

            if (itineraryAvailabilitiesOptional.isEmpty()) {
                availabilityStatus = CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityStatus.SoldOut;
                continue;
            }

            var ticketAvailability = itineraryAvailabilitiesOptional.get();

            if (ticketAvailability.availabilityStatus == CS5722.FlightApiEngine.AvailabilityApi.Repository.Database.Entity.AvailabilityStatus.SoldOut)
                availabilityStatus = CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityStatus.SoldOut;
        }

        return availabilityStatus;
    }
}

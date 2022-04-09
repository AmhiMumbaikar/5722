package CS5722.FlightApiEngine.AvailabilityApi.Service;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Director.IAvailabilityResponseBuilderDirector;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.IAvailabilityResponseRepository;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.IItineraryRepository;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.*;
import CS5722.FlightApiEngine.AvailabilityApi.Service.Entity.AvailabilityRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AvailabilityServiceTest {

    @Mock
    private IItineraryRepository itineraryRepository;

    @Mock
    private IAvailabilityResponseRepository availabilityResponseRepository;

    @Mock
    private IAvailabilityResponseBuilderDirector availabilityResponseBuilderDirector;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AvailabilityService availabilityService;

    @Test
    public void checkAvailability () {

        var itinerary = new Itinerary();
        itinerary.setItineraryId(UUID.randomUUID().toString());
        var segment = new Segment();
        segment.setSegmentId(UUID.randomUUID().toString());
        segment.setDepartureCode("ABC");
        segment.setArrivalCode("XYZ");
        segment.setDepartureDate("2022-09-03");
        segment.setArrivalDate("2022-09-03");
        segment.setDurationInMinutes(100);
        segment.setFlightNo(123);
        segment.setTravelClass(TravelClass.Economy);
        segment.setWaitingTimeInMinutes(10);
        var price = new Price();
        price.setPriceId(UUID.randomUUID().toString());
        price.setAmount(100);
        price.setCurrencyCode(CurrencyCode.Eur);
        segment.setPrice(price);
        var journey = new Journey();
        journey.setJourneyId(UUID.randomUUID().toString());
        journey.setWay(Way.Out);
        journey.setDuration(100);
        journey.setSegments(List.of(segment));
        itinerary.setJourneys(List.of(journey));

        Mockito.when(itineraryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(itinerary));

        var validCreditCards = List.of(Map.of("XX","Arbitrary Card type"));

        var availabilityResponse = new AvailabilityResponse(UUID.randomUUID().toString(),itinerary,AvailabilityStatus.Available,validCreditCards);

        Mockito.when(availabilityResponseBuilderDirector.buildAvailabilityResponse(Mockito.any())).thenReturn(availabilityResponse);

        Mockito.when(availabilityResponseRepository.save(availabilityResponse)).thenReturn(availabilityResponse);

        availabilityService.checkAvailability(new AvailabilityRequest(UUID.randomUUID().toString()));
    }

}

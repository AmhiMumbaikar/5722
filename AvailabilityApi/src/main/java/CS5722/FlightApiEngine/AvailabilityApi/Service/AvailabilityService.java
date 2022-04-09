package CS5722.FlightApiEngine.AvailabilityApi.Service;

import CS5722.FlightApiEngine.AvailabilityApi.Exception.TokenExpiredException;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.IAvailabilityResponseRepository;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.IItineraryRepository;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Director.IAvailabilityResponseBuilderDirector;
import CS5722.FlightApiEngine.AvailabilityApi.Service.Entity.AvailabilityRequest;
import CS5722.FlightApiEngine.AvailabilityApi.Service.Entity.AvailabilityResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
class AvailabilityService implements IAvailabilityService {

    private final IItineraryRepository itineraryRepository;

    private final IAvailabilityResponseRepository availabilityResponseRepository;

    private final ModelMapper modelMapper;

    private final IAvailabilityResponseBuilderDirector availabilityResponseBuilderDirector;

    public AvailabilityService (
            IItineraryRepository itineraryRepository,IAvailabilityResponseRepository availabilityResponseRepository,
            ModelMapper modelMapper,IAvailabilityResponseBuilderDirector availabilityResponseBuilderDirector
    ) {
        this.itineraryRepository = itineraryRepository;
        this.availabilityResponseRepository = availabilityResponseRepository;
        this.modelMapper = modelMapper;
        this.availabilityResponseBuilderDirector = availabilityResponseBuilderDirector;
    }

    @Override
    public AvailabilityResponse checkAvailability ( AvailabilityRequest request ) {
        var searchItinerary = fetchItinerary(request.getItineraryId());

        var availabilityResponse = availabilityResponseBuilderDirector.buildAvailabilityResponse(searchItinerary);

        availabilityResponseRepository.save(availabilityResponse);

        return modelMapper.map(availabilityResponse,AvailabilityResponse.class);
    }

    private CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary fetchItinerary ( String itineraryId ) throws TokenExpiredException {
        var itineraryOptional = itineraryRepository.findById(itineraryId);

        if (itineraryOptional.isPresent()) return itineraryOptional.get();

        throw new TokenExpiredException("Invalid or expired - " + itineraryId);
    }
}
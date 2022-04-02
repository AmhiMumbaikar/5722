package CS5722.FlightApiEngine.SearchApi.Service;

import CS5722.FlightApiEngine.SearchApi.Service.Adapter.INearbyAirportCodesAdapter;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Command.IItineraryDevelopmentCommand;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.Itinerary;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.SearchRequest;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.SearchResponse;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.TripType;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
class SearchService implements ISearchService {

    // This can also be the best example of builder pattern but since not implemented from scratch not accentuating
    private final ModelMapper modelMapper;

    private final INearbyAirportCodesAdapter nearbyAirportCodesAdapter;

    private final IItineraryDevelopmentCommand oneWayItineraryDevelopmentCommand;

    private final IItineraryDevelopmentCommand returnItineraryDevelopmentCommand;

    public SearchService (
            ModelMapper modelMapper,
            INearbyAirportCodesAdapter nearbyAirportCodesAdapter,
            IItineraryDevelopmentCommand oneWayItineraryDevelopmentCommand,
            IItineraryDevelopmentCommand returnItineraryDevelopmentCommand
    ) {
        this.modelMapper = modelMapper;
        this.nearbyAirportCodesAdapter = nearbyAirportCodesAdapter;
        this.oneWayItineraryDevelopmentCommand = oneWayItineraryDevelopmentCommand;
        this.returnItineraryDevelopmentCommand = returnItineraryDevelopmentCommand;
    }

    /*
    WE ONLY SUPPORT DIRECT FLIGHTS
    Rules for both will come from the spring cloud server
     */
    @Override
    public SearchResponse fetchAllItineraries ( SearchRequest request ) {

        var allDepartureCodes = nearbyAirportCodesAdapter.getAllNearbyAirportCodes(request.getFromCode());

        var allArrivalCodes = nearbyAirportCodesAdapter.getAllNearbyAirportCodes(request.getToCode());

        if (request.getTripType() == TripType.OneWay) {
            var itineraries = oneWayItineraryDevelopmentCommand.execute(allDepartureCodes,allArrivalCodes,
                    request.getFromDate(),request.getToDate());

            return new SearchResponse(modelMapper.map(itineraries,new TypeToken<List<Itinerary>>() {
            }.getType()));
        }

        var itineraries = returnItineraryDevelopmentCommand.execute(allDepartureCodes,allArrivalCodes,
                request.getFromDate(),request.getToDate());

        return new SearchResponse(modelMapper.map(itineraries,new TypeToken<List<Itinerary>>() {
        }.getType()));
    }
}

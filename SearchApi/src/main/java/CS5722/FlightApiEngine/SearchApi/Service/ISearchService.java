package CS5722.FlightApiEngine.SearchApi.Service;

import CS5722.FlightApiEngine.SearchApi.Service.Entity.*;

public interface ISearchService {

    SearchResponse fetchAllItineraries ( SearchRequest request );
}

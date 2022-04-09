package CS5722.FlightApiEngine.SearchApi.Controller;

import CS5722.FlightApiEngine.SearchApi.Config.AirportCodesConfig;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.SearchRequest;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.TripType;
import CS5722.FlightApiEngine.SearchApi.Service.ISearchService;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.*;
import CS5722.FlightApiEngine.SearchApi.controller.SearchController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SearchController.class)
class SearchControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ISearchService searchService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AirportCodesConfig airportCodesConfig;

    @Test
    void search() throws Exception {

        var searchRequest = new SearchRequest();
        searchRequest.setFromCode("ABC");
        searchRequest.setToCode("XYZ");
        searchRequest.setFromDate("2022-09-03");
        searchRequest.setPaxCount(1);
        searchRequest.setTripType(TripType.OneWay);

        var searchResponse = new SearchResponse();
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
        searchResponse.setItineraries(List.of(itinerary));

        Mockito.when(searchService.fetchAllItineraries(searchRequest)).thenReturn(searchResponse);

        var list = new ArrayList<String>();

        list.add("ABC");
        list.add("XYZ");

        // Mock dependency of the validator
        Mockito.when(airportCodesConfig.getValidAirportCodes()).thenReturn(list);

        // Ideally Mock the modelmapper so that the unit test does not go inside the model mapper of unit test execution

        var request = post("/search").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(searchRequest));

        var result = mvc.perform(request).andReturn();

        assertEquals(objectMapper.writeValueAsString(searchResponse),result.getResponse().getContentAsString());
    }
}
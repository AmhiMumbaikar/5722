package CS5722.FlightApiEngine.SearchApi.controller;

import CS5722.FlightApiEngine.SearchApi.Service.ISearchService;
import CS5722.FlightApiEngine.SearchApi.controller.Entity.SearchRequest;
import CS5722.FlightApiEngine.SearchApi.controller.Entity.SearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    private final ISearchService searchService;

    private final ModelMapper modelMapper;

    public SearchController ( ISearchService searchService,ModelMapper modelMapper ) {
        this.searchService = searchService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public SearchResponse search ( @RequestBody @Valid SearchRequest request ) {
        log.info("Inside flight search Api request...");

        var searchRequest = modelMapper.map(request,
                CS5722.FlightApiEngine.SearchApi.Service.Entity.SearchRequest.class);

        var searchResponse = searchService.fetchAllItineraries(searchRequest);

        return modelMapper.map(searchResponse, SearchResponse.class);
    }
}
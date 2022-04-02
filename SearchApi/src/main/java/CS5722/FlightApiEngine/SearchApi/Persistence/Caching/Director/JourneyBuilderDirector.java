package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Director;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Builder.IJourneyBuilder;
import CS5722.FlightApiEngine.SearchApi.Service.Entity.Way;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JourneyBuilderDirector {

    private final ModelMapper modelMapper;

    public JourneyBuilderDirector ( ModelMapper modelMapper ) {
        this.modelMapper = modelMapper;
    }

    public CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Journey getDirectJourney (
            IJourneyBuilder journeyBuilder,Way way,CS5722.FlightApiEngine.SearchApi.Persistence.Database.Entity.Segment outSegment
    ) {
        journeyBuilder.setWayAndDirection(modelMapper.map(way,CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Way.class),outSegment.getDurationInMinutes());
        journeyBuilder.setSegments(List.of(modelMapper.map(outSegment,CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Segment.class)));

        return journeyBuilder.getJourney();
    }
}

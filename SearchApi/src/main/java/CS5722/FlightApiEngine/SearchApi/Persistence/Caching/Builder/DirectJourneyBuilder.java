package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Builder;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Journey;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Segment;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Way;

import java.util.List;
import java.util.UUID;

public class DirectJourneyBuilder implements IJourneyBuilder {

    private final String journeyId = UUID.randomUUID().toString();

    private Way way;

    private int duration; // In minutes

    private List<Segment> segments;

    @Override
    public void setWayAndDirection ( Way way,int duration ) {
        this.way = way;
        this.duration = duration;
    }

    @Override
    public void setSegments ( List<Segment> segments ) {
        this.segments = segments;
    }

    @Override
    public Journey getJourney () {
        return new Journey(this.journeyId,this.way,this.duration,this.segments);
    }
}

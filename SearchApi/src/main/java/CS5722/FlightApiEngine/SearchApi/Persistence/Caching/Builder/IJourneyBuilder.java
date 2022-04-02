package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Builder;

import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Journey;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Segment;
import CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Entity.Way;

import java.util.List;

// The builder interface is merely to demonstrate the use of builder pattern
// Else we have open source or licensed libraries to leverage the pattern with additional benefits
public interface IJourneyBuilder {

    void setWayAndDirection ( Way way, int duration );

    void setSegments ( List<Segment> segments );

    Journey getJourney ();
}

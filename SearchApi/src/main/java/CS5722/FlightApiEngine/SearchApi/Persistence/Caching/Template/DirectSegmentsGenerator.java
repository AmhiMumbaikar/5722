package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Template;

import CS5722.FlightApiEngine.SearchApi.Persistence.Database.Entity.Segment;
import CS5722.FlightApiEngine.SearchApi.Persistence.Database.ISegmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DirectSegmentsGenerator extends SegmentsGenerator {

    public DirectSegmentsGenerator ( ISegmentRepository segmentRepository ) {
        super(segmentRepository);
    }

    @Override
    public void modifySegments ( List<Segment> segments ) {
        // Not required as this is a direct journey
        // But this will be required when we will generate connecting segments
    }
}

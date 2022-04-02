package CS5722.FlightApiEngine.SearchApi.Persistence.Caching.Template;

import CS5722.FlightApiEngine.SearchApi.Persistence.Database.Entity.Segment;
import CS5722.FlightApiEngine.SearchApi.Persistence.Database.ISegmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Best example of template pattern
public abstract class SegmentsGenerator {

    private final ISegmentRepository segmentRepository;

    public SegmentsGenerator ( ISegmentRepository segmentRepository ) {
        this.segmentRepository = segmentRepository;
    }

    // The below code is an example of the template pattern

    public List<Segment> generateSegments (
            List<String> allCodes1,List<String> allCodes2,String date1,String date2
    ) {

        var segments = new ArrayList<Segment>();

        for (var code1 : allCodes1) {
            for (var code2 : allCodes2) {
                segments.addAll(getSegments(code1,date1,code2,date2));
            }
        }

        modifySegments(segments);

        return segments;
    }

    private List<CS5722.FlightApiEngine.SearchApi.Persistence.Database.Entity.Segment> getSegments (
            String fromCode,String fromDate,String toCode,String toDate
    ) {
        // New business Rule ***
        // The below code shall be updated to search between the departure and arrival date and their datatype shall
        // be DateTime

        // Example
        // findAllByArrivalDateLessThanEqualAndDepartureCodeGreaterThanEqual(OffsetDateTime departureDate,
        // OffsetDateTime
        // arrivalDate);

        var segments = segmentRepository.findByDepartureCodeAndDepartureDateAndArrivalCodeAndArrivalDate(fromCode,fromDate,toCode,toDate);

        return segments.stream().filter(f -> f.getScore() >= 0.25).collect(Collectors.toList());
    }

    public abstract void modifySegments ( List<Segment> segments );
}

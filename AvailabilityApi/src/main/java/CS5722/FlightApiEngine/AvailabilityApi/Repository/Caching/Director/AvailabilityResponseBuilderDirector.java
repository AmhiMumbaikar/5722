package CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Director;

import CS5722.FlightApiEngine.AvailabilityApi.Config.CreditCardsConfig;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Builder.AvailabilityResponseBuilder;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.AvailabilityResponse;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.Entity.Itinerary;
import CS5722.FlightApiEngine.AvailabilityApi.Repository.Strategy.IAvailabilityStatusStrategy;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AvailabilityResponseBuilderDirector implements IAvailabilityResponseBuilderDirector {

    private final CreditCardsConfig creditCardsConfig;

    private final IAvailabilityStatusStrategy simpleAvailabilityStatusStrategy;

    public AvailabilityResponseBuilderDirector (
            CreditCardsConfig creditCardsConfig,
            IAvailabilityStatusStrategy simpleAvailabilityStatusStrategy
    ) {
        this.creditCardsConfig = creditCardsConfig;
        this.simpleAvailabilityStatusStrategy = simpleAvailabilityStatusStrategy;
    }

    public AvailabilityResponse buildAvailabilityResponse ( Itinerary searchItinerary ) {
        var availabilityResponseBuilder = new AvailabilityResponseBuilder();

        availabilityResponseBuilder.setAvailabilityId(UUID.randomUUID().toString());

        availabilityResponseBuilder.setItinerary(searchItinerary);

        availabilityResponseBuilder.setValidCreditCards(creditCardsConfig.getValidCreditCards());
// Client
        availabilityResponseBuilder.setAvailabilityStatus(simpleAvailabilityStatusStrategy.deduceAvailabilityStatus(searchItinerary));

        return availabilityResponseBuilder.getAvailabilityResponse();
    }
}

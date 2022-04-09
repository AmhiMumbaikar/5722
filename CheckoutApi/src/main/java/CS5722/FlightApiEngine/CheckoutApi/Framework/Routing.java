package CS5722.FlightApiEngine.CheckoutApi.Framework;

import CS5722.FlightApiEngine.CheckoutApi.Exception.SoldOutException;
import CS5722.FlightApiEngine.CheckoutApi.Framework.Dispatcher.InterceptorManagerDispatcher;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity.AvailabilityStatus;
import CS5722.FlightApiEngine.CheckoutApi.Service.Entity.Booking;
import CS5722.FlightApiEngine.CheckoutApi.Service.Entity.CheckoutRequest;
import CS5722.FlightApiEngine.CheckoutApi.Service.ICheckoutService;
import org.springframework.stereotype.Component;

// ACCEPTING REQUEST IN FRAMEWORK LIKE AN EVENT
@Component
public class Routing implements IRouting {

    private final ICheckoutService checkoutService;

    private final InterceptorManagerDispatcher interceptorManagerDispatcher;

    public Routing ( ICheckoutService checkoutService,InterceptorManagerDispatcher interceptorManagerDispatcher ) {
        this.checkoutService = checkoutService;
        this.interceptorManagerDispatcher = interceptorManagerDispatcher;
    }

    @Override
    public Booking checkoutItinerary ( CheckoutRequest request ) {

        var availabilityResponse = checkoutService.fetchAvailability(request.getAvailabilityId());

        if (availabilityResponse.getAvailabilityStatus() == AvailabilityStatus.SoldOut) {
            throw new SoldOutException("Fare sold out - " + request.getAvailabilityId());
        }

        // Context object is booking and is created by the application and not framework
        // Create Pending Booking First which is CONTEXT object
        var booking = checkoutService.createPendingBooking(request,availabilityResponse);

        // Call dispatcher
        return interceptorManagerDispatcher.interceptRequest(booking);
    }
}

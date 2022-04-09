package CS5722.FlightApiEngine.CheckoutApi.Service;

import CS5722.FlightApiEngine.CheckoutApi.Exception.TokenExpiredException;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity.AvailabilityResponse;
import CS5722.FlightApiEngine.CheckoutApi.Service.Entity.CheckoutRequest;

public interface ICheckoutService {
    CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking createPendingBooking (
            CheckoutRequest request,AvailabilityResponse availabilityResponse
    );

    CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity.AvailabilityResponse fetchAvailability ( String availabilityId ) throws TokenExpiredException;
}

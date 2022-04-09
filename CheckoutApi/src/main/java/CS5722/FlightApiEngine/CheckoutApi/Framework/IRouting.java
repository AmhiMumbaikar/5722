package CS5722.FlightApiEngine.CheckoutApi.Framework;

import CS5722.FlightApiEngine.CheckoutApi.Service.Entity.Booking;
import CS5722.FlightApiEngine.CheckoutApi.Service.Entity.CheckoutRequest;

// PLEASE NOTE WE ARE NOT CREATING ANY REAL FRAMEWORK HERE TO PROVIDE EXTENSION
// We are simulating interception behaviour
public interface IRouting {
    Booking checkoutItinerary ( CheckoutRequest request );
}

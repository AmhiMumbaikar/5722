package CS5722.FlightApiEngine.CheckoutApi.Framework.Interceptor;

import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking;

public interface IInterceptor {
    public void doTask( Booking booking);
}

package CS5722.FlightApiEngine.CheckoutApi.Service.Application;

import CS5722.FlightApiEngine.CheckoutApi.Framework.Dispatcher.InterceptorManagerDispatcher;
import CS5722.FlightApiEngine.CheckoutApi.Framework.Interceptor.IInterceptor;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.IBookingRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Qualifier("databaseInterceptor")
public class DatabaseInterceptor implements IInterceptor {

    private final IBookingRepository bookingRepository;

    private final InterceptorManagerDispatcher interceptorManagerDispatcher;

    public DatabaseInterceptor ( IBookingRepository bookingRepository,InterceptorManagerDispatcher interceptorManager ) {
        this.bookingRepository = bookingRepository;
        this.interceptorManagerDispatcher = interceptorManager;
    }

    @PostConstruct
    public void registerInterceptorWithDispatcher()
    {
        this.interceptorManagerDispatcher.attachInterceptor(this);
    }

    @Override
    public void doTask ( Booking booking ) {
        // We can access context object - booking internals and methods
        bookingRepository.save(booking);
    }
}

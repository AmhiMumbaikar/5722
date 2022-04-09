package CS5722.FlightApiEngine.CheckoutApi.Framework.Dispatcher;

import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking;
import CS5722.FlightApiEngine.CheckoutApi.Framework.Interceptor.IInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InterceptorManagerDispatcher {
    private final InterceptorChainDispatcher interceptorChainDispatcher;

    public InterceptorManagerDispatcher ( ModelMapper modelMapper ) {
        this.interceptorChainDispatcher = new InterceptorChainDispatcher(modelMapper);
    }

    public void attachInterceptor ( IInterceptor interceptor ) {
        interceptorChainDispatcher.attachInterceptor(interceptor);
    }

    public CS5722.FlightApiEngine.CheckoutApi.Service.Entity.Booking interceptRequest ( Booking booking) {
        return interceptorChainDispatcher.execute(booking);
    }
}
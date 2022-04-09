package CS5722.FlightApiEngine.CheckoutApi.Framework.Dispatcher;

import CS5722.FlightApiEngine.CheckoutApi.Service.Entity.Booking;
import CS5722.FlightApiEngine.CheckoutApi.Framework.Interceptor.IInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InterceptorChainDispatcher {

    private final ModelMapper modelMapper;

    private final List<IInterceptor> interceptors = new ArrayList<>();

    public InterceptorChainDispatcher ( ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void attachInterceptor ( IInterceptor interceptor )
    {
        this.interceptors.add(interceptor);
    }

    public Booking execute ( CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking booking ) {

        // Iterating over all the interceptors
        for(var interceptor : interceptors)
        {
            interceptor.doTask(booking);
        }

        return modelMapper.map(booking,Booking.class);
    }
}

package CS5722.FlightApiEngine.CheckoutApi.Config;

import CS5722.FlightApiEngine.CheckoutApi.Service.Event.BookingEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class BookingEventPublisherConfig {

    @Bean
    public Sinks.Many<BookingEvent> bookingSinks(){
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<BookingEvent>> bookingSupplier(Sinks.Many<BookingEvent> sinks){
        return sinks::asFlux;
    }
}

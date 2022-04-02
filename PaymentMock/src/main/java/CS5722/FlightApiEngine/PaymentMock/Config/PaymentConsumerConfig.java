package CS5722.FlightApiEngine.PaymentMock.Config;

import CS5722.FlightApiEngine.PaymentMock.Event.BookingEvent;
import CS5722.FlightApiEngine.PaymentMock.Event.Entity.BookingStatus;
import CS5722.FlightApiEngine.PaymentMock.Event.Entity.PaymentRequest;
import CS5722.FlightApiEngine.PaymentMock.Event.PaymentEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Configuration
public class PaymentConsumerConfig {

    @Bean
    public Function<Flux<BookingEvent>, Flux<PaymentEvent>> paymentProcessor () {
        return orderEventFlux -> orderEventFlux.flatMap(this::processPayment);
    }

    private Mono<PaymentEvent> processPayment ( BookingEvent bookingEvent ) {
        var paymentRequest = new PaymentRequest(bookingEvent.getBookingRequest().getBookingId());

        if (Objects.equals(bookingEvent.getBookingRequest().getPaymentInformation().getCardType(),"DS")) {
            return Mono.fromSupplier(() -> new PaymentEvent(paymentRequest,BookingStatus.Failed));
        }
        return Mono.fromSupplier(() -> new PaymentEvent(paymentRequest,BookingStatus.Booked));
    }
}
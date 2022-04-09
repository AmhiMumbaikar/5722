package CS5722.FlightApiEngine.CheckoutApi.Config;

import CS5722.FlightApiEngine.CheckoutApi.Service.BookingStatusUpdateHandler;
import CS5722.FlightApiEngine.CheckoutApi.Service.Event.PaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class PaymentEventConsumerConfig {

    private final BookingStatusUpdateHandler bookingStatusUpdateHandler;

    public PaymentEventConsumerConfig ( BookingStatusUpdateHandler bookingStatusUpdateHandler ) {
        this.bookingStatusUpdateHandler = bookingStatusUpdateHandler;
    }

    @Bean
    public Consumer<PaymentEvent> paymentEventConsumer () {

        return ( payment ) -> {
            log.info(String.valueOf(payment));
            bookingStatusUpdateHandler.updateBooking(payment.getPaymentRequest(),payment.getBookingStatus());
        };
    }
}
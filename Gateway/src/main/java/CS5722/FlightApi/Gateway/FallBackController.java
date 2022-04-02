package CS5722.FlightApi.Gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @PostMapping("/searchApiFallBack")
    public Mono<ResponseEntity<String>> searchApiFallBackMethod () {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Search Api is under maintenance"));
    }

    @PostMapping("/availabilityApiFallBack")
    public Mono<ResponseEntity<String>> availabilityApiFallBackMethod () {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Availability Api is under " +
                "maintenance"));
    }

    @PostMapping("/checkoutApiFallBack")
    public Mono<ResponseEntity<String>> checkoutApiFallBackMethod () {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Checkout Api is under " +
                "maintenance"));
    }

    @GetMapping("/bookingsApiFallBack")
    public Mono<ResponseEntity<String>> bookingsApiFallBack () {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Bookings Api is " + "under " +
                "maintenance"));
    }
}
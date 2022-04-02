package CS5722.FlightApiEngine.BookingsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"CS5722.FlightApiEngine.BookingsApi.Entity"})
public class BookingQueryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingQueryApiApplication.class, args);
	}

}

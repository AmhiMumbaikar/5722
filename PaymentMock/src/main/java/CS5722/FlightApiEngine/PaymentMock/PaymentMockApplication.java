package CS5722.FlightApiEngine.PaymentMock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaymentMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMockApplication.class, args);
	}

}

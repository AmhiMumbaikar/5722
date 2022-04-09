package CS5722.FlightApiEngine.AvailabilityApi;

import CS5722.FlightApiEngine.AvailabilityApi.Config.CreditCardsConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"CS5722.FlightApiEngine.AvailabilityApi.Repository.Database"})
@EnableConfigurationProperties(CreditCardsConfig.class)
public class AvailabilityApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvailabilityApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper () {
		return new ModelMapper();
	}
}

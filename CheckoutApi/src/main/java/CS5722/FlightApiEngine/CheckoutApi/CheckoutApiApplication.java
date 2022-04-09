package CS5722.FlightApiEngine.CheckoutApi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity"})
@EnableAspectJAutoProxy
public class CheckoutApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper () {
		return new ModelMapper();
	}
}

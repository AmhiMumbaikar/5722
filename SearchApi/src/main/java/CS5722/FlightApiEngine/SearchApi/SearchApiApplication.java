package CS5722.FlightApiEngine.SearchApi;

import CS5722.FlightApiEngine.SearchApi.Config.AirportCodesConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"CS5722.FlightApiEngine.SearchApi.Persistence.Database.Entity"})
@EnableConfigurationProperties(AirportCodesConfig.class)
public class SearchApiApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(SearchApiApplication.class,args);
    }

    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }
}

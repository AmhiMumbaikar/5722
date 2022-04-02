package CS5722.FlightApi.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class GatewayApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain ( ServerHttpSecurity http ) {
        http.csrf(ServerHttpSecurity.CsrfSpec::disable);
        return http.build();
    }
}

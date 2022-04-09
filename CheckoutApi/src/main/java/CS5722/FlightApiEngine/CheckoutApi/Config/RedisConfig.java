package CS5722.FlightApiEngine.CheckoutApi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Bean
    @Primary
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory ( RedisConfiguration defaultRedisConfig ) {
        var clientConfig = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(60000)).build();
        return new LettuceConnectionFactory(defaultRedisConfig,clientConfig);
    }

    @Bean
    public RedisConfiguration defaultRedisConfig () {
        return new RedisStandaloneConfiguration();
    }
}


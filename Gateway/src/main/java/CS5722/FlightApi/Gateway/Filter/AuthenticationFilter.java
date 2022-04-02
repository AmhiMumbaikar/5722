package CS5722.FlightApi.Gateway.Filter;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<Config> {

    @Value("${tenant.name}")
    private String name;

    @Value("${tenant.password}")
    private String password;

    public AuthenticationFilter () {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply ( Config config ) {

        return ( exchange,chain ) -> {

            var request = exchange.getRequest();

            if (this.isAuthMissing(request))
                return this.onError(exchange,"Missing authorization header");

            var authorizationHeaderValue = this.getAuthHeader(request);

            if (isAuthValNullOrEmpty(authorizationHeaderValue)) {
                return this.onError(exchange,"Missing authorization header value");
            }

            var decodedCredentials = new String(Base64.getDecoder().decode(authorizationHeaderValue));

            var clientCredentials = decodedCredentials.split(":",2);

            if (clientCredentials.length != 2 || clientCredentials[0] == null || !clientCredentials[0].equals(this.name) || clientCredentials[1] == null || !clientCredentials[1].equals(this.password)) {
                return this.onError(exchange,"Invalid authorization header value");
            }

            return chain.filter(exchange);
        };
    }

    private @NotNull Mono<Void> onError ( @NotNull ServerWebExchange exchange,@NotNull String errorMessage ) {
        ServerHttpResponse response = exchange.getResponse();

        response.setStatusCode(HttpStatus.UNAUTHORIZED);

        var bytes = errorMessage.getBytes(StandardCharsets.UTF_8);

        var buffer = exchange.getResponse().bufferFactory().wrap(bytes);

        return exchange.getResponse().writeWith(Flux.just(buffer));
    }

    private @NotNull String getAuthHeader ( @NotNull ServerHttpRequest request ) {

        return request.getHeaders().getOrEmpty(HttpHeaders.AUTHORIZATION).get(0).replace("Basic","").trim();
    }

    private boolean isAuthMissing ( @NotNull ServerHttpRequest request ) {

        return !request.getHeaders().containsKey("Authorization");
    }

    private boolean isAuthValNullOrEmpty ( String authVal ) {

        return authVal == null || authVal.trim().isEmpty();
    }
}

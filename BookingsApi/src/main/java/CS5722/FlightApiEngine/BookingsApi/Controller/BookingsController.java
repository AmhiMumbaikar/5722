package CS5722.FlightApiEngine.BookingsApi.Controller;

import CS5722.FlightApiEngine.BookingsApi.Service.IGraphQLService;
import graphql.ExecutionInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingsController {

    private final IGraphQLService graphQLService;

    public BookingsController ( IGraphQLService graphQLService ) {
        this.graphQLService = graphQLService;
    }

    @SuppressWarnings (value="unchecked")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCheckoutResponse ( @RequestBody Map<String, Object> request) {

        var executionInput = ExecutionInput.newExecutionInput()
                .query((String) request.get("query"))
                .operationName((String) request.get("operationName"))
                .variables((Map<String, Object>) request.get("variables"))
                .build();

        var execute = graphQLService.getGraphQL().execute(executionInput);

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}

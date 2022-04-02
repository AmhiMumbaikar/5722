package CS5722.FlightApiEngine.BookingsApi.Service;

import CS5722.FlightApiEngine.BookingsApi.Mediator.Mediator;
import graphql.GraphQL;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class GraphQLService extends IColleague implements IGraphQLService {
    Mediator mediator;
    private GraphQL graphQL;

    public GraphQLService (
            Mediator mediator
    ) {
        this.mediator = mediator;
    }

    // load schema at application start up
    @PostConstruct
    private void loadSchema () throws IOException {

        var resource = new ClassPathResource("/booking.graphql");
        var dataArr = FileCopyUtils.copyToByteArray(resource.getInputStream());
        var data = new String(dataArr, StandardCharsets.UTF_8);
        // parse schema
        var typeRegistry = new SchemaParser().parse(data);
        var wiring = mediator.buildRuntimeWiring();
        var schema = new SchemaGenerator().makeExecutableSchema(typeRegistry,wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    public GraphQL getGraphQL () {
        return graphQL;
    }
}
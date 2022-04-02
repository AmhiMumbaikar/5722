package CS5722.FlightApiEngine.BookingsApi.Mediator;

import CS5722.FlightApiEngine.BookingsApi.Entity.Booking;
import graphql.schema.idl.RuntimeWiring;

import java.util.List;

public abstract class Mediator {
    public abstract RuntimeWiring buildRuntimeWiring ();

    public abstract Booking find (String bookingId);

    public abstract List<Booking> findAll ();
}

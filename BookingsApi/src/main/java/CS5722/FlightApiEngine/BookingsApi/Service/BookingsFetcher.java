package CS5722.FlightApiEngine.BookingsApi.Service;

import CS5722.FlightApiEngine.BookingsApi.Entity.Booking;
import CS5722.FlightApiEngine.BookingsApi.Mediator.Mediator;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;

public class BookingsFetcher extends IColleague implements DataFetcher<List<Booking>> {

    private Mediator mediator;

    public void setMediator ( Mediator mediator ) {
        this.mediator = mediator;
    }

    @Override
    public List<Booking> get ( DataFetchingEnvironment dataFetchingEnvironment ) {
        return mediator.findAll();
    }
}
package CS5722.FlightApiEngine.BookingsApi.Service;

import CS5722.FlightApiEngine.BookingsApi.Entity.Booking;
import CS5722.FlightApiEngine.BookingsApi.Mediator.Mediator;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class BookingFetcher extends IColleague implements DataFetcher<Booking> {

    private Mediator mediator;

    public void setMediator ( Mediator mediator ) {
        this.mediator = mediator;
    }

    @Override
    public Booking get ( DataFetchingEnvironment dataFetchingEnvironment ) {
        return mediator.find(dataFetchingEnvironment.getArgument("bookingId"));
    }
}
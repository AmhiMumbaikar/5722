package CS5722.FlightApiEngine.BookingsApi.Mediator;

import CS5722.FlightApiEngine.BookingsApi.Entity.Booking;
import CS5722.FlightApiEngine.BookingsApi.Repository.IBookingRepository;
import CS5722.FlightApiEngine.BookingsApi.Service.BookingFetcher;
import CS5722.FlightApiEngine.BookingsApi.Service.BookingsFetcher;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataFetcherMediator extends Mediator {

    private final IBookingRepository bookingRepository;
    private BookingsFetcher bookingsFetcher;
    private BookingFetcher bookingFetcher;

    public DataFetcherMediator ( IBookingRepository bookingRepository ) {
        this.bookingRepository = bookingRepository;

        // Mediator logic
        setBookingsFetcher(new BookingsFetcher());
        setBookingFetcher(new BookingFetcher());
    }

    public void setBookingsFetcher ( BookingsFetcher bookingsFetcher ) {
        this.bookingsFetcher = bookingsFetcher;
        this.bookingsFetcher.setMediator(this);
    }

    public void setBookingFetcher ( BookingFetcher bookingFetcher ) {
        this.bookingFetcher = bookingFetcher;
        this.bookingFetcher.setMediator(this);
    }

    @Override
    public RuntimeWiring buildRuntimeWiring () {
        return RuntimeWiring.newRuntimeWiring().type("Query",typeWiring -> typeWiring.dataFetcher("allBookings",bookingsFetcher).dataFetcher("booking",bookingFetcher)).build();
    }

    @Override
    public List<Booking> findAll () {
        return bookingRepository.findAll();
    }

    @Override
    public Booking find ( String bookingId ) {
        var bookingOptional = bookingRepository.findById(bookingId);
        return bookingOptional.orElse(null);
    }
}

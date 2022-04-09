package CS5722.FlightApiEngine.CheckoutApi.Service;

import CS5722.FlightApiEngine.CheckoutApi.Exception.TokenExpiredException;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity.AvailabilityResponse;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.IAvailabilityResponseRepository;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.BookingStatus;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.ContactInformation;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Itinerary;
import CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.PaymentInformation;
import CS5722.FlightApiEngine.CheckoutApi.Service.Entity.CheckoutRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckoutService implements ICheckoutService {

    private final IAvailabilityResponseRepository availabilityResponseRepository;

    private final ModelMapper modelMapper;

    public CheckoutService (
            IAvailabilityResponseRepository availabilityResponseRepository,ModelMapper modelMapper
    ) {
        this.availabilityResponseRepository = availabilityResponseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking createPendingBooking (
            CheckoutRequest request,AvailabilityResponse availabilityResponse
    ) {

        var booking = new CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.Booking();

        booking.setBookingStatus(BookingStatus.Pending);
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setItinerary(modelMapper.map(availabilityResponse.getItinerary(),Itinerary.class));

        var contactInformation = modelMapper.map(request.getContactInformation(),ContactInformation.class);
        contactInformation.setContactId(UUID.randomUUID().toString());
        booking.setContactInformation(contactInformation);

        var paymentInformation = modelMapper.map(request.getPaymentInformation(),PaymentInformation.class);
        paymentInformation.setPaymentId(UUID.randomUUID().toString());
        booking.setPaymentInformation(paymentInformation);
        booking.setCurrencyCode(modelMapper.map(request.getCurrencyCode(),CS5722.FlightApiEngine.CheckoutApi.Repository.Database.Entity.CurrencyCode.class));

        return booking;
    }

    @Override
    public CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.Entity.AvailabilityResponse fetchAvailability ( String availabilityId ) throws TokenExpiredException {
        var availabilityResponseOptional = availabilityResponseRepository.findById(availabilityId);

        if (availabilityResponseOptional.isPresent())
            return availabilityResponseOptional.get();

        throw new TokenExpiredException("Invalid or expired - " + availabilityId);
    }
}

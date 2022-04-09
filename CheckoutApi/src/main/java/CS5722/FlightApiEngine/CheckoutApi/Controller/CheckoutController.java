package CS5722.FlightApiEngine.CheckoutApi.Controller;

import CS5722.FlightApiEngine.CheckoutApi.Controller.Entity.CheckoutRequest;
import CS5722.FlightApiEngine.CheckoutApi.Controller.Entity.CheckoutResponse;
import CS5722.FlightApiEngine.CheckoutApi.Framework.IRouting;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    // PURPOSELY USING IROUTER IN FRAMEWORK PACKAGE
    private final IRouting routing;

    private final ModelMapper modelMapper;

    public CheckoutController ( IRouting routing,ModelMapper modelMapper ) {
        this.routing = routing;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public CheckoutResponse checkout ( @RequestBody @Valid CheckoutRequest request ) {

        var checkoutRequest = modelMapper.map(request,
                CS5722.FlightApiEngine.CheckoutApi.Service.Entity.CheckoutRequest.class);

        return modelMapper.map(routing.checkoutItinerary(checkoutRequest),CheckoutResponse.class);
    }
}

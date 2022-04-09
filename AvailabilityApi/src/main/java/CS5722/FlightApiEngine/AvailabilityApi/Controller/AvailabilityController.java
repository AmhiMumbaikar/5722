package CS5722.FlightApiEngine.AvailabilityApi.Controller;

import CS5722.FlightApiEngine.AvailabilityApi.Controller.Entity.AvailabilityRequest;
import CS5722.FlightApiEngine.AvailabilityApi.Service.IAvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/availability")
@Slf4j
public class AvailabilityController {

    private final IAvailabilityService availabilityService;

    private final ModelMapper modelMapper;

    public AvailabilityController ( IAvailabilityService availabilityService,ModelMapper modelMapper ) {
        this.availabilityService = availabilityService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public CS5722.FlightApiEngine.AvailabilityApi.Service.Entity.AvailabilityResponse Availability ( @RequestBody @Valid AvailabilityRequest request ) {
        log.info("Inside flight availability Api request...");

        var availabilityRequest = modelMapper.map(request,
                CS5722.FlightApiEngine.AvailabilityApi.Service.Entity.AvailabilityRequest.class);

        return availabilityService.checkAvailability(availabilityRequest);
    }
}
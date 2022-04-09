package CS5722.FlightApiEngine.CheckoutApi.Validator;

import CS5722.FlightApiEngine.CheckoutApi.Repository.Caching.IAvailabilityResponseRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidAvailabilityIdValidator implements ConstraintValidator<ValidAvailabilityId, String> {

    private final IAvailabilityResponseRepository availabilityResponseRepository;
    private String message;

    public ValidAvailabilityIdValidator ( IAvailabilityResponseRepository availabilityResponseRepository ) {
        this.availabilityResponseRepository = availabilityResponseRepository;
    }

    @Override
    public void initialize ( ValidAvailabilityId validId ) {
        this.message =
                String.format(validId.message(),validId.propName()).concat("; ").concat(validId.additionalMessage());
    }

    @Override
    public boolean isValid ( String availabilityId,ConstraintValidatorContext constraintValidatorContext ) {

        if (availabilityId != null && availabilityResponseRepository.findById(availabilityId).isPresent()) return true;

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(availabilityId != null ? this.message.concat(
                "; ").concat(availabilityId) : this.message).addConstraintViolation();

        return false;
    }
}


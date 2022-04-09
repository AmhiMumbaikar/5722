package CS5722.FlightApiEngine.AvailabilityApi.Validator;

import CS5722.FlightApiEngine.AvailabilityApi.Repository.Caching.IItineraryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidItineraryIdValidator implements ConstraintValidator<ValidItineraryId, String> {

    private final IItineraryRepository itineraryRepository;
    private String message;

    public ValidItineraryIdValidator ( IItineraryRepository itineraryRepository ) {
        this.itineraryRepository = itineraryRepository;
    }

    @Override
    public void initialize ( ValidItineraryId validId ) {
        this.message =
                String.format(validId.message(),validId.propName()).concat("; ").concat(validId.additionalMessage());
    }

    @Override
    public boolean isValid ( String itineraryId,ConstraintValidatorContext constraintValidatorContext ) {

        if (itineraryId != null && itineraryRepository.findById(itineraryId).isPresent()) return true;

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(itineraryId != null ? this.message.concat("; "
        ).concat(itineraryId) : this.message).addConstraintViolation();

        return false;
    }
}

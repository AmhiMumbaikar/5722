package CS5722.FlightApiEngine.SearchApi.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPaxCountValidator implements ConstraintValidator<ValidPaxCount, Integer> {

    @Override
    public boolean isValid ( Integer code,ConstraintValidatorContext constraintValidatorContext ) {
        var valid = code > 0;

        if (valid) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate("paxCount must be > 0").addConstraintViolation();
        return false;
    }
}
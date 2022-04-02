package CS5722.FlightApiEngine.SearchApi.Validator;

import CS5722.FlightApiEngine.SearchApi.Config.AirportCodesConfig;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidAirportCodeValidator implements ConstraintValidator<ValidAirportCode, String> {

    private final AirportCodesConfig airportCodesConfig;
    private String message;

    public ValidAirportCodeValidator ( AirportCodesConfig airportCodesConfig ) {
        this.airportCodesConfig = airportCodesConfig;
    }

    @Override
    public void initialize ( ValidAirportCode validAirportCode ) {
        this.message = String.format(validAirportCode.message(),validAirportCode.propName());
    }

    @Override
    public boolean isValid ( String code,ConstraintValidatorContext constraintValidatorContext ) {

        var valid = code != null && airportCodesConfig.getValidAirportCodes().contains(code);

        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(this.message.concat("; ").concat(code)).addConstraintViolation();
        }

        return valid;
    }
}
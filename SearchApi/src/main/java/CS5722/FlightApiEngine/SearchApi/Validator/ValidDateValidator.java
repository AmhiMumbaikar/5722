package CS5722.FlightApiEngine.SearchApi.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {

    private String message;
    private boolean nullable;

    @Override
    public void initialize ( ValidDate validAirportCode ) {
        this.message = String.format(validAirportCode.message(),validAirportCode.propName());
        this.nullable = validAirportCode.nullable();
    }

    @Override
    public boolean isValid ( String date,ConstraintValidatorContext constraintValidatorContext ) {

        if (this.nullable && date == null) {
            return true;
        }

        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(this.message.concat("; ").concat(date)).addConstraintViolation();
            return false;
        }
        return true;
    }
}
package CS5722.FlightApiEngine.CheckoutApi.Validator;

import CS5722.FlightApiEngine.CheckoutApi.Controller.Entity.CurrencyCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCurrencyCodeValidator implements ConstraintValidator<ValidCurrencyCode, CurrencyCode> {

    private String message;

    @Override
    public void initialize ( ValidCurrencyCode validCurrencyCode ) {
        this.message = validCurrencyCode.message();
    }

    @Override
    public boolean isValid ( CurrencyCode currencyCode,ConstraintValidatorContext constraintValidatorContext ) {
        if (currencyCode == null) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(this.message.concat(" ; ")).addConstraintViolation();
            return false;
        }

        return true;
    }
}

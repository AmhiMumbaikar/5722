package CS5722.FlightApiEngine.CheckoutApi.Validator;

import CS5722.FlightApiEngine.CheckoutApi.Controller.Entity.ContactInformation;
import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidContactInformationValidator implements ConstraintValidator<ValidContactInformation,
        ContactInformation> {

    private String message;

    @Override
    public void initialize ( ValidContactInformation validContactInformation ) {
        this.message = validContactInformation.message();
    }

    @Override
    public boolean isValid (
            ContactInformation contactInformation,ConstraintValidatorContext constraintValidatorContext
    ) {

        if (contactInformation == null) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }

        var validEmail = EmailValidator.getInstance().isValid(contactInformation.getEmail());
        var validPhoneNumber = contactInformation.getPhoneNumber().matches("^(1-)?[0-9]{3}-?[0-9]{3}-?[0-9]{4" + "}$");

        if (validEmail && validPhoneNumber) return true;

        StringBuilder messageBuilder = new StringBuilder();

        if (!validEmail) {
            messageBuilder.append("Invalid email - ").append(contactInformation.getEmail()).append("; ");
        }

        if (!validPhoneNumber) {
            messageBuilder.append("Invalid phoneNumber - ").append(contactInformation.getPhoneNumber()).append("; ");
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(messageBuilder.toString()).addConstraintViolation();
        return false;
    }
}


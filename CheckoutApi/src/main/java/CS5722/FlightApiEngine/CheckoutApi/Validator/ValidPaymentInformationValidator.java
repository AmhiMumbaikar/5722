package CS5722.FlightApiEngine.CheckoutApi.Validator;

import CS5722.FlightApiEngine.CheckoutApi.Controller.Entity.PaymentInformation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class ValidPaymentInformationValidator implements ConstraintValidator<ValidPaymentInformation, PaymentInformation> {

    private String message;

    @Override
    public void initialize ( ValidPaymentInformation validPaymentInformation ) {
        this.message = validPaymentInformation.message();
    }

    @Override
    public boolean isValid (
            PaymentInformation paymentInformation,ConstraintValidatorContext constraintValidatorContext
    ) {

        if (paymentInformation == null) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }

        StringBuilder messageBuilder = new StringBuilder();

        // Get from Cloud Config Server
        if (paymentInformation.getCardType() == null || paymentInformation.getCardType().isEmpty()) {
            messageBuilder.append("Invalid cardType - ").append(paymentInformation.getCardType()).append("; ");
        }

        if (paymentInformation.getCardNumber() == null || paymentInformation.getCardNumber().isEmpty() || paymentInformation.getCardNumber().length() != 16 || !paymentInformation.getCardNumber().matches("[0-9]+")) {
            messageBuilder.append("Invalid cardNumber - ").append(paymentInformation.getCardNumber()).append("; ");
        }

        // 3-4 digits CVV
        if (paymentInformation.getCvv() < 111 || paymentInformation.getCvv() > 9999) {
            messageBuilder.append("Invalid cvv - ").append(paymentInformation.getCvv()).append("; ");
        }

        if (paymentInformation.getCardHolderName() == null || paymentInformation.getCardHolderName().isEmpty()) {
            messageBuilder.append("Invalid cardHolderName - ").append(paymentInformation.getCardHolderName()).append("; ");
        }

        if (paymentInformation.getExpiryMonth() <= 0 && paymentInformation.getExpiryMonth() > 12) {
            messageBuilder.append("Invalid month - ").append(paymentInformation.getExpiryMonth()).append("; ");
        }

        if (paymentInformation.getExpiryYear() >= (Calendar.getInstance().get(Calendar.YEAR) % 100) && paymentInformation.getExpiryYear() < 100) {
            messageBuilder.append("Invalid year - ").append(paymentInformation.getExpiryYear()).append("; ");
        }

        if (messageBuilder.length() == 0)
            return true;

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(messageBuilder.toString()).addConstraintViolation();
        return false;
    }
}


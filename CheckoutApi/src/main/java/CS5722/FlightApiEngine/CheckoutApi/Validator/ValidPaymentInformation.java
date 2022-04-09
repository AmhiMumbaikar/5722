package CS5722.FlightApiEngine.CheckoutApi.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidPaymentInformationValidator.class)
public @interface ValidPaymentInformation {
    String message () default "Invalid paymentInformation";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
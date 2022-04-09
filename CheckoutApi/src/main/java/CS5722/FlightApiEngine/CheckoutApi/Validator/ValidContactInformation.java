package CS5722.FlightApiEngine.CheckoutApi.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidContactInformationValidator.class)
public @interface ValidContactInformation {
    String message () default "Invalid contactInformation";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
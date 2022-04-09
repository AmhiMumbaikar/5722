package CS5722.FlightApiEngine.CheckoutApi.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidAvailabilityIdValidator.class)
public @interface ValidAvailabilityId {
    String message() default "Not a valid availability id - %s";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String propName();

    String additionalMessage();
}

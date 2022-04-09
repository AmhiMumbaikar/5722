package CS5722.FlightApiEngine.AvailabilityApi.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidItineraryIdValidator.class)
public @interface ValidItineraryId {
    String message() default "Not a valid id - %s";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String propName();

    String additionalMessage();
}
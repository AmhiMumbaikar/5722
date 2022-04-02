package CS5722.FlightApiEngine.SearchApi.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidPaxCountValidator.class)
public @interface ValidPaxCount {

    String message() default "must be less than or equal to %s";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

package CS5722.FlightApiEngine.SearchApi.Validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidDateValidator.class)
public @interface ValidDate {

    String message() default "not a valid date - %s";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String propName ();

    boolean nullable();
}
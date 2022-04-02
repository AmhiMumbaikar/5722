package CS5722.FlightApiEngine.SearchApi.Validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidAirportCodeValidator.class)
public @interface ValidAirportCode {
    String message() default "Not a valid airport code - %s";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String propName();
}
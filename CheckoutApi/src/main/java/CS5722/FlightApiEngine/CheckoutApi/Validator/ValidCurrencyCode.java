package CS5722.FlightApiEngine.CheckoutApi.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidCurrencyCodeValidator.class)
public @interface ValidCurrencyCode {
    String message() default "Not a valid currency code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

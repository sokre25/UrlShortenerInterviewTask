package hr.infobip.urlshortenertask.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = RedirectTypeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedirectTypeConstraint {
    String message() default "Invalid redirect type, it should be 302 or 301";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

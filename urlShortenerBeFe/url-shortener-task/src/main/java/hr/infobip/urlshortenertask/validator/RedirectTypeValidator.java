package hr.infobip.urlshortenertask.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RedirectTypeValidator implements ConstraintValidator<RedirectTypeConstraint, Integer> {
    @Override
    public void initialize(RedirectTypeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && (integer.intValue() == 302 || integer.intValue() == 301);
    }
}

package com.example.cronparser.CustomValidator;

import com.example.cronparser.CustomValidator.OneOfPattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class OneOfPatternValidator implements ConstraintValidator<OneOfPattern, String> {
    private String[] patterns;

    @Override
    public void initialize(OneOfPattern constraintAnnotation) {
        patterns = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Arrays.stream(patterns).anyMatch(value::matches);
    }
}

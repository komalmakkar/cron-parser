package com.example.cronparser.models.corevalidation;

import com.example.cronparser.CustomValidator.OneOfPattern;
import com.example.cronparser.constants.Regex;
import lombok.Getter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import com.example.cronparser.models.BadRequestException;

@Getter
public class Hour {
    //@Pattern(regexp = "^(\\*|[01]?[0-9]|2[0-3]|(?:[01]?[0-9]|2[0-3])-(?:[01]?[0-9]|2[0-3])|\\?|\\*/[1-9][0-9]*)$")
    @OneOfPattern(value = {
            Regex.ALL_EXPRESSION,
            Regex.HOUR_24_EXPRESSION,
            Regex.HOUR_24_RANGE_EXPRESSION,
            Regex.HOUR_REPEAT_EXPRESSION
    })
    String hour;

    public void setHour(String hour) throws BadRequestException {
        this.hour = hour;

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Hour>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            throw new BadRequestException(violations.iterator().next().getMessage());
        }
    }
}

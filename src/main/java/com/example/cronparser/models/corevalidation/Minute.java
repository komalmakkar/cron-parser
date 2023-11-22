package com.example.cronparser.models.corevalidation;

import com.example.cronparser.CustomValidator.OneOfPattern;
import com.example.cronparser.constants.ErrorMessages;
import com.example.cronparser.constants.Regex;
import com.example.cronparser.models.BadRequestException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Getter
@NoArgsConstructor
public class Minute {
    //@Pattern(regexp = "^([0-9]|[1-5][0-9]$|^\\*|,|-|/)$")
    //@Pattern(regexp = "^([0-5]?[0-9]|\\*|\\*/[1-5]?[0-9])(,([0-5]?[0-9]|\\*|\\*/[1-5]?[0-9]))*$")
    @OneOfPattern(value = {
            Regex.ALL_EXPRESSION,
            Regex.MINUTES_EXPRESSION,
            Regex.MINUTES_RANGE_EXPRESSION,
            Regex.MINUTES_REPEAT_EXPRESSION
    },
            message = ErrorMessages.InvalidInput_MinutesInvalid)
    String minute;

    public void setMinute(String minute) throws BadRequestException {
        this.minute = minute;

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Minute>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            throw new BadRequestException(violations.iterator().next().getMessage());
        }
    }
}

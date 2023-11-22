package com.example.cronparser.models.corevalidation;

import com.example.cronparser.CustomValidator.OneOfPattern;
import com.example.cronparser.constants.Regex;
import com.example.cronparser.models.BadRequestException;
import lombok.Getter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Getter
public class DayOfTheMonth {
    @OneOfPattern(value = {
            Regex.ALL_EXPRESSION,
            Regex.ANY_EXPRESSION,
            Regex.DAYS_OF_MONTH_EXPRESSION,
            Regex.RANGE_OF_DAYS_OF_MONTH_EXPRESSION,
            Regex.DAYS_OF_MONTH_REPEAT_EXPRESSION
    })
    String dayOfTheMonth;

    public void setDayOfTheMonth(String dayOfTheMonth) throws BadRequestException {
        this.dayOfTheMonth = dayOfTheMonth;

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<DayOfTheMonth>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            throw new BadRequestException(violations.iterator().next().getMessage());
        }
    }
}

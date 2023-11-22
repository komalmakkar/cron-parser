package com.example.cronparser.models.corevalidation;

import com.example.cronparser.CustomValidator.OneOfPattern;
import com.example.cronparser.constants.Regex;
import com.example.cronparser.models.BadRequestException;
import lombok.Getter;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

@Getter
public class DayOfTheWeek {
    //@Pattern(regexp = "^(sun|mon|tue|wed|thu|fri|sat|[1-7]|(?:[1-7]|sun|mon|tue|wed|thu|fri|sat)-(?:[1-7]|sun|mon|tue|wed|thu|fri|sat)|\\*)$")
    @OneOfPattern(value = {
            Regex.ALL_EXPRESSION,
            Regex.ANY_EXPRESSION,
            Regex.DAYS_OF_THE_WEEK_NUMERIC_EXPRESSION,
            Regex.DAYS_OF_THE_WEEK_NUMERIC_RANGE_EXPRESSION,
            Regex.DAYS_OF_THE_WEEK_ALIAS_EXPRESSION,
            Regex.DAYS_OF_THE_WEEK_ALIAS_RANGE_EXPRESSION

    })
    String dayOfTheWeek;

    public void setDayOfTheWeek(String dayOfTheWeek) throws BadRequestException {
        this.dayOfTheWeek = dayOfTheWeek;

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<DayOfTheWeek>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            throw new BadRequestException(violations.iterator().next().getMessage());
        }
    }
}

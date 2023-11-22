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
public class Month {
    //@NonNull
    //@Pattern(regexp = "^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec|\\*|0?[1-9]|1[0-2]|(?:jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-(?:jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)|\\?|\\*/[1-9][0-9]*|[1-9]|1[0-2]-[1-9]|1[0-2]-1[0-2])$")
    @OneOfPattern(value = {
            Regex.ALL_EXPRESSION,
            Regex.MONTH_NUMERIC_EXPRESSION,
            Regex.MONTH_NUMERIC_RANGE_EXPRESSION,
            Regex.MONTH_NUMERIC_REPEAT_EXPRESSION,
            Regex.MONTH_ALPHA_EXPRESSION,
            Regex.MONTH_ALPHA_RANGE_EXPRESSION

    })
    String month;

    public void setMonth(String month) throws BadRequestException {
        this.month = month;

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Month>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            throw new BadRequestException(violations.iterator().next().getMessage());
        }
    }
}

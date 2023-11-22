package com.example.cronparser.CustomValidator;

import com.example.cronparser.constants.Regex;
import com.example.cronparser.models.BadRequestException;
import com.example.cronparser.models.corevalidation.DayOfTheMonth;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OneOfPatternValidatorTest {

    @OneOfPattern(value = {
        Regex.ALL_EXPRESSION,
        Regex.ANY_EXPRESSION,
        Regex.DAYS_OF_MONTH_EXPRESSION,
        Regex.RANGE_OF_DAYS_OF_MONTH_EXPRESSION,
        Regex.DAYS_OF_MONTH_REPEAT_EXPRESSION
    })
    String dayOfTheMonth;

    @Test
    void testIsValidReturnsTrueWhenValueMatchesOneOfThePatterns() {
        this.dayOfTheMonth = "12";
        // Act

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<OneOfPatternValidatorTest>> violations = validator.validate(this);


        // Assert
        assertTrue(violations.isEmpty());
    }

    @Test
    void testIsValidReturnsFalseWhenValueDoesNotMatchAnyPattern() {
        // Arrange
        this.dayOfTheMonth = "123as";

        // Act

        // Act

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<OneOfPatternValidatorTest>> violations = validator.validate(this);
        // Assert
        assertFalse(violations.isEmpty());
    }
}

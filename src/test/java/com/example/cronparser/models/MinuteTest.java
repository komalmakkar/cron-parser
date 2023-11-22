package com.example.cronparser.models;

import static org.junit.jupiter.api.Assertions.*;

import com.example.cronparser.models.corevalidation.Minute;
import org.junit.jupiter.api.Test;


class MinuteTest {

    final String exceptionMessage = "must match \"^([0-5]?[0-9]|\\*|\\*/[1-5]?[0-9])(,([0-5]?[0-9]|\\*|\\*/[1-5]?[0-9]))*$\"";
    /**
    * Valid Test Cases
    */
    @Test
    void testSetMinuteValid_Numeric() {
        Minute minute = new Minute();
        String validMinute = "30";

        assertDoesNotThrow(() -> minute.setMinute(validMinute));
    }

    @Test
    void testSetMinuteValid_Star() {
        Minute minute = new Minute();
        String validMinute = "*";

        assertDoesNotThrow(() -> minute.setMinute(validMinute));
    }

    @Test
    void testSetMinuteValid_StarDivided10() {
        Minute minute = new Minute();
        String validMinute = "*/10";

        assertDoesNotThrow(() -> minute.setMinute(validMinute));
    }


    @Test
    void testSetMinuteValid_NumericZero() {
        Minute minute = new Minute();
        String validMinute = "0";

        assertDoesNotThrow(() -> minute.setMinute(validMinute));
    }

    @Test
    void testSetMinuteValid_NumericWithin0and59() {
        Minute minute = new Minute();
        String validMinute = "55";

        assertDoesNotThrow(() -> minute.setMinute(validMinute));
    }

    /**
    * Negative Test Cases
    */
    @Test
    void testSetMinuteInvalid_alphaNumeric_MustThrow() {
        Minute minute = new Minute();
        String invalidMinute = "abc1";

        assertThrows(BadRequestException.class, () -> minute.setMinute(invalidMinute));
    }

    @Test
    void testSetMinuteInvalid_NumericMoreThan59_MustThrow() {
        Minute minute = new Minute();
        String invalidMinute = "60";

        assertThrows(BadRequestException.class, () -> minute.setMinute(invalidMinute));
    }

    @Test
    void testSetMinuteInvalid_NumericMultipleZeros_MustThrow() {
        Minute minute = new Minute();
        String invalidMinute = "000";

        assertThrows(BadRequestException.class, () -> minute.setMinute(invalidMinute));
    }

    @Test
    void testSetMinuteInalid_NumericMoreThan59_MustThrow() {
        Minute minute = new Minute();
        String invalidMinute = "60";

        assertThrows(BadRequestException.class, () -> minute.setMinute(invalidMinute));
    }

    @Test
    void testSetMinuteInvalid_StarDivided65_MustThrow() {
        Minute minute = new Minute();
        String invalidMinute = "*/65";

        assertThrows(BadRequestException.class, () -> minute.setMinute(invalidMinute));
    }

}

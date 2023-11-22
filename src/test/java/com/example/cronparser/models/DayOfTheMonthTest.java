package com.example.cronparser.models;

import com.example.cronparser.models.corevalidation.DayOfTheMonth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfTheMonthTest {

    @Test
    void testsetDayOfTheMonthValid() {
        DayOfTheMonth dom = new DayOfTheMonth();

        assertDoesNotThrow(() -> dom.setDayOfTheMonth("1"));

        assertDoesNotThrow(() -> dom.setDayOfTheMonth("10"));

        assertDoesNotThrow(() -> dom.setDayOfTheMonth("1-19"));

        assertDoesNotThrow(() -> dom.setDayOfTheMonth("?"));

        assertDoesNotThrow(() -> dom.setDayOfTheMonth("*"));

        assertDoesNotThrow(() -> dom.setDayOfTheMonth("*/2"));
    }

    @Test
    void testsetDayOfTheMonthInvalid() {
        DayOfTheMonth dom = new DayOfTheMonth();

        assertThrows(BadRequestException.class, () -> dom.setDayOfTheMonth("100"));

        assertThrows(BadRequestException.class, () -> dom.setDayOfTheMonth("-1"));

        assertThrows(BadRequestException.class, () -> dom.setDayOfTheMonth("1-99"));

        assertThrows(BadRequestException.class, () -> dom.setDayOfTheMonth("1-1-1"));

        assertThrows(BadRequestException.class, () -> dom.setDayOfTheMonth("asdf"));

        assertThrows(BadRequestException.class, () ->  dom.setDayOfTheMonth("0"));

    }

}

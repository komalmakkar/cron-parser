package com.example.cronparser.models;

import com.example.cronparser.models.corevalidation.Month;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthTest {
    @Test
    void testSetMonthValid() {
        Month month = new Month();

        assertDoesNotThrow(() -> month.setMonth("11"));
        assertDoesNotThrow(() -> month.setMonth("12"));
        assertDoesNotThrow(() -> month.setMonth("11-12"));
        assertDoesNotThrow(() -> month.setMonth("*/2"));
        assertDoesNotThrow(() -> month.setMonth("jan"));
        assertDoesNotThrow(() -> month.setMonth("feb"));
        assertDoesNotThrow(() -> month.setMonth("jan-mar"));
        assertDoesNotThrow(() -> month.setMonth("*"));
    }

    @Test
    void testSetMonthInvalid() {
        Month month = new Month();

        assertThrows(BadRequestException.class, () -> month.setMonth("100"));
        assertThrows(BadRequestException.class, () -> month.setMonth("-1"));
        assertThrows(BadRequestException.class, () -> month.setMonth("1-99"));
        assertThrows(BadRequestException.class, () -> month.setMonth("1-1-1"));
        assertThrows(BadRequestException.class, () -> month.setMonth("asdf"));
        assertThrows(BadRequestException.class, () -> month.setMonth("?"));
    }
}

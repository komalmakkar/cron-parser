package com.example.cronparser.models;

import com.example.cronparser.models.corevalidation.Hour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourTest {

    /**
     * Valid Test Cases
     */
    @Test
    void testSetHourValid() {
        Hour hour = new Hour();

        assertDoesNotThrow(() -> hour.setHour("1"));

        assertDoesNotThrow(() -> hour.setHour("10"));

        assertDoesNotThrow(() -> hour.setHour("0"));

        assertDoesNotThrow(() -> hour.setHour("1-19"));

        assertDoesNotThrow(() -> hour.setHour("*"));

        assertDoesNotThrow(() -> hour.setHour("*/2"));
    }

    @Test
    void testSetHourInvalid() {
        Hour hour = new Hour();

        assertThrows(BadRequestException.class, () -> hour.setHour("100"));

        assertThrows(BadRequestException.class, () -> hour.setHour("-1"));

        assertThrows(BadRequestException.class, () -> hour.setHour("1-99"));

        assertThrows(BadRequestException.class, () -> hour.setHour("1-1-1"));

        assertThrows(BadRequestException.class, () -> hour.setHour("asdf"));
    }
}

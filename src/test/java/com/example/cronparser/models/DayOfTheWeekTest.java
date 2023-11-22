package com.example.cronparser.models;

import static org.junit.jupiter.api.Assertions.*;

import com.example.cronparser.models.corevalidation.DayOfTheWeek;
import org.junit.jupiter.api.Test;


class DayOfTheWeekTest {

    @Test
    void testValidInputMon() throws BadRequestException {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertDoesNotThrow(() -> dayOfTheWeek.setDayOfTheWeek("mon"));
    }

    @Test
    void testValidInputSun() throws BadRequestException {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertDoesNotThrow(() -> dayOfTheWeek.setDayOfTheWeek("sun"));
    }

    @Test
    void testValidInputRange1To4() throws BadRequestException {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertDoesNotThrow(() -> dayOfTheWeek.setDayOfTheWeek("1-4"));
    }

    @Test
    void testValidInputRangeMonToWed() throws BadRequestException {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertDoesNotThrow(() -> dayOfTheWeek.setDayOfTheWeek("mon-wed"));
    }

    @Test
    void testValidInputRangeFriToMon() throws BadRequestException {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertDoesNotThrow(() -> dayOfTheWeek.setDayOfTheWeek("fri-mon"));
    }

    @Test
    void testValidInputNumber1() throws BadRequestException {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertDoesNotThrow(() -> dayOfTheWeek.setDayOfTheWeek("1"));
    }
    @Test
    void testInvalidInputZero() {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertThrows(BadRequestException.class, () -> dayOfTheWeek.setDayOfTheWeek("0"));
    }

    @Test
    void testInvalidInputNumber77() {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertThrows(BadRequestException.class, () -> dayOfTheWeek.setDayOfTheWeek("77"));
    }

    @Test
    void testInvalidInputNumber123() {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertThrows(BadRequestException.class, () -> dayOfTheWeek.setDayOfTheWeek("123"));
    }

    @Test
    void testInvalidInputMons() {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertThrows(BadRequestException.class, () -> dayOfTheWeek.setDayOfTheWeek("mons"));
    }

    @Test
    void testInvalidInputMons0() {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertThrows(BadRequestException.class, () -> dayOfTheWeek.setDayOfTheWeek("mons0"));
    }

    @Test
    void testInvalidInputMonSunss() {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertThrows(BadRequestException.class, () -> dayOfTheWeek.setDayOfTheWeek("mon-sunss"));
    }

    @Test
    void testInvalidInputRange4To99() {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        assertThrows(BadRequestException.class, () -> dayOfTheWeek.setDayOfTheWeek("4-99"));
    }
}


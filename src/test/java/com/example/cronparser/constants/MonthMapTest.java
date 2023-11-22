package com.example.cronparser.constants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonthMapTest {
    @Test
    void testGetMapping() {
        int january = MonthMap.getMapping("jan");
        assertEquals(1, january);

        int december = MonthMap.getMapping("dec");
        assertEquals(12, december);
    }

    @Test
    void testHasMapping() {
        boolean hasJanuary = MonthMap.hasMapping("jan");
        assertTrue(hasJanuary);

        boolean hasInvalidMonth = MonthMap.hasMapping("invalid");
        assertFalse(hasInvalidMonth);
    }   
}

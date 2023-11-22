package com.example.cronparser.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysOfWeekMapTest {
    @Test
    void testGetMapping_ValidKey_ReturnsMapping() {
        // Arrange
        String key = "mon";
        int expectedMapping = 2;

        // Act
        int result = DaysOfWeekMap.getMapping(key);

        // Assert
        assertEquals(expectedMapping, result);
    }

    @Test
    void testHasMapping_ValidKey_ReturnsTrue() {
        // Arrange
        String key = "sun";

        // Act
        boolean result = DaysOfWeekMap.hasMapping(key);

        // Assert
        assertTrue(result);
    }

    @Test
    void testHasMapping_InvalidKey_ReturnsFalse() {
        // Arrange
        String key = "invalid";

        // Act
        boolean result = DaysOfWeekMap.hasMapping(key);

        // Assert
        assertFalse(result);
    }
}

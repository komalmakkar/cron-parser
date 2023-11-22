package com.example.cronparser.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void testAddBufferWhitespace_InputLengthLessThan14_ReturnsInputWithBufferWhitespace() {
        // Arrange
        String input = "Hello";
        String expected = input + "         ";

        // Act
        String result = StringUtil.addBufferWhitespace(input, 14);

        // Assert
        assertEquals(expected, result);
    }

}
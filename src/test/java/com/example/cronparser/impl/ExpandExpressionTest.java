package com.example.cronparser.impl;

import com.example.cronparser.models.BadRequestException;
import com.example.cronparser.models.ParsedResponse;
import com.example.cronparser.models.UserInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpandExpressionTest {
    @Test
    void RepeatHourQuery() throws BadRequestException {
        // Create a UserInput object with sample values
        UserInput userInput = new UserInput("*/15", "0-1","1-8", "*", "3-5", "/komal");


        // Create an instance of ExpandExpression
        ExpandExpression expandExpression = new ExpandExpression();

        // Call the run method and get the ParsedResponse
        ParsedResponse parsedResponse = expandExpression.run(userInput);

        // Assert the values in the ParsedResponse object
        int[] expected = {1,2,3,4,5,6,7,8,9,10,11,12};
        int [] parsed = parsedResponse.getMonths().stream()
            .mapToInt(Integer::intValue)
            .toArray();
        assertArrayEquals(expected, parsed);
    }

    @Test
    void ReleatHourAndListHourQuery() throws BadRequestException {
        // Create a UserInput object with sample values
        UserInput userInput = new UserInput("*/15,15,3", "0-1","1-8", "*", "3-5", "/komal");


        // Create an instance of ExpandExpression
        ExpandExpression expandExpression = new ExpandExpression();

        // Call the run method and get the ParsedResponse
        ParsedResponse parsedResponse = expandExpression.run(userInput);

        // Assert the values in the ParsedResponse object
        int[] expected = {0,3,15,15,30,45};
        int [] parsed = parsedResponse.getMinutes().stream()
            .mapToInt(Integer::intValue)
            .toArray();
        assertArrayEquals(expected, parsed);
    }

    @Test
    void testRun_monthAsRange_Valid() throws BadRequestException {
        // Create a UserInput object with sample values
        UserInput userInput = new UserInput("*/15,15,3", "0-1","1-8", "5-9", "3-5", "/komal");


        // Create an instance of ExpandExpression
        ExpandExpression expandExpression = new ExpandExpression();

        // Call the run method and get the ParsedResponse
        ParsedResponse parsedResponse = expandExpression.run(userInput);

        // Assert the values in the ParsedResponse object
        int[] expected = {5, 6,7,8,9};
        int [] parsed = parsedResponse.getMonths().stream()
            .mapToInt(Integer::intValue)
            .toArray();
        assertArrayEquals(expected, parsed);
    }

    @Test
    void testRun_monthAsRepeat_Valid() throws BadRequestException {
        // Create a UserInput object with sample values
        UserInput userInput = new UserInput("*/15,15,3", "0-1","1-8", "*/5", "2", "/komal");


        // Create an instance of ExpandExpression
        ExpandExpression expandExpression = new ExpandExpression();

        // Call the run method and get the ParsedResponse
        ParsedResponse parsedResponse = expandExpression.run(userInput);

        // Assert the values in the ParsedResponse object
        int[] expected = {5, 10};
        int [] parsed = parsedResponse.getMonths().stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        assertArrayEquals(expected, parsed);

    }
}

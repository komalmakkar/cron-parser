package com.example.cronparser.impl;

import com.example.cronparser.models.ParsedResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PostProcessisngRemoveDuplicatesTest {
    @Test
    void testRun() {
        // Create a sample ParsedResponse object
        ParsedResponse parsedResponse = new ParsedResponse();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 1, 2, 3));
        parsedResponse.setHours(arrayList);
        parsedResponse.setMinutes(arrayList);
        parsedResponse.setDaysOfTheMonths(arrayList);
        parsedResponse.setMonths(arrayList);
        parsedResponse.setDaysOfTheWeek(arrayList);

        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3));

        // Create an instance of the PostProcessisngRemoveDuplicates class
        PostProcessisngRemoveDuplicates postProcessor = new PostProcessisngRemoveDuplicates();

        // Call the run method
        ParsedResponse result = postProcessor.run(parsedResponse);

        // Assert that the duplicates have been removed
        assertArrayEquals(expectedList.toArray(), result.getHours().toArray());
        assertArrayEquals(expectedList.toArray(), result.getMinutes().toArray());
        assertArrayEquals(expectedList.toArray(), result.getDaysOfTheMonths().toArray());
        assertArrayEquals(expectedList.toArray(), result.getMonths().toArray());
        assertArrayEquals(expectedList.toArray(), result.getDaysOfTheWeek().toArray());
    }
}

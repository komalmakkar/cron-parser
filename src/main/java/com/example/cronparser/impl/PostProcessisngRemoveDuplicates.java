package com.example.cronparser.impl;

import com.example.cronparser.Interfaces.IPostProcessing;
import com.example.cronparser.models.ParsedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.stream.Collectors;

@Component
@Slf4j
public class PostProcessisngRemoveDuplicates implements IPostProcessing {
    @Override
    public ParsedResponse run(ParsedResponse parsedResponse) {
        log.info("Removing duplicates from the parsed response");
        parsedResponse.setHours(removeDuplicates(parsedResponse.getHours()));
        parsedResponse.setMinutes(removeDuplicates(parsedResponse.getMinutes()));
        parsedResponse.setDaysOfTheMonths(removeDuplicates(parsedResponse.getDaysOfTheMonths()));
        parsedResponse.setMonths(removeDuplicates(parsedResponse.getMonths()));
        parsedResponse.setDaysOfTheWeek(removeDuplicates(parsedResponse.getDaysOfTheWeek()));

        return parsedResponse;
    }

    private List<Integer> removeDuplicates(List<Integer> listWithDuplicates) {
        return listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

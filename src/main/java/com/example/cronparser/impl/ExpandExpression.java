package com.example.cronparser.impl;

import com.example.cronparser.Interfaces.IExpandExpression;
import com.example.cronparser.constants.DaysOfWeekMap;
import com.example.cronparser.constants.MonthMap;
import com.example.cronparser.constants.Regex;
import com.example.cronparser.models.*;
import com.example.cronparser.models.corevalidation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class ExpandExpression implements IExpandExpression {

    @Override
    public ParsedResponse run(UserInput userInput) {
        ParsedResponse parsedResponse = new ParsedResponse();
        parsedResponse.setHours(getHours(userInput.getHours()));
        parsedResponse.setMinutes(getMinutes(userInput.getMinutes()));
        parsedResponse.setDaysOfTheMonths(getDaysOfMonths(userInput.getDaysOfTheMonths()));
        parsedResponse.setMonths(getMonth(userInput.getMonths()));
        parsedResponse.setDaysOfTheWeek(getDayOfTheWeek(userInput.getDaysOfTheWeek()));
        parsedResponse.setCommand(userInput.getCommand());
        return parsedResponse;
    }

    private List<Integer> getDayOfTheWeek(List<DayOfTheWeek> daysOfTheWeek) {
        List<Integer> result = new ArrayList<Integer>();
        int lowerbound = 1, upperbound = 7;

        boolean found = daysOfTheWeek.stream()
            .anyMatch(x -> Pattern.compile(Regex.ALL_EXPRESSION).matcher(x.getDayOfTheWeek()).find());
        if (found) {
            for (int i = lowerbound; i <= upperbound; i++) {
                result.add(i);
            }
        }
        else {
            for (DayOfTheWeek dayOfTheWeek : daysOfTheWeek) {
                String dow = dayOfTheWeek.getDayOfTheWeek();
                if(this.isInteger(dow)) {
                    result.add(Integer.parseInt(dow));
                }
                else if(this.isRange(dow)) {
                    result.addAll(getIntegerListInRange(dow));
                }
                // TODO: test and verify this for alpha days
            }
        }

        Collections.sort(result);
        return result;
    }

    private List<Integer> getMonth(List<Month> months) {
        List<Integer> result = new ArrayList<Integer>();
        int lowerbound = 1, upperbound = 12;
        boolean found = months.stream()
            .anyMatch(x -> Pattern.compile(Regex.ALL_EXPRESSION).matcher(x.getMonth()).find());
        if (found) {
            for (int i = lowerbound; i <= upperbound; i++) {
                result.add(i);
            }
        }
        else {
            for (Month month : months) {
                String mon = month.getMonth();
                if(this.isInteger(mon)) {
                    result.add(Integer.parseInt(mon));
                }
                else if(this.isRange(mon)) {
                    result.addAll(getIntegerListInRange(mon));
                }
                else if (this.isRepeat(mon, Regex.MONTH_NUMERIC_REPEAT_EXPRESSION)) {
                    result.addAll(getRepeatList(mon, 1, 12));
                }
                // TODO: Handle cases for alpha names.
            }
        }

        Collections.sort(result);
        return result;
    }

    private List<Integer> getDaysOfMonths(List<DayOfTheMonth> daysOfTheMonths) {
        List<Integer> result = new ArrayList<Integer>();
        int lowerbound = 1, upperbound = 31;
        boolean found = daysOfTheMonths.stream()
            .anyMatch(x -> Pattern.compile(Regex.ALL_EXPRESSION).matcher(x.getDayOfTheMonth()).find());
        if (found) {
            for (int i = lowerbound; i <= upperbound; i++) {
                result.add(i);
            }
        }
        else {
            for (DayOfTheMonth dom : daysOfTheMonths) {
                if(this.isInteger(dom.getDayOfTheMonth())) {
                    result.add(Integer.parseInt(dom.getDayOfTheMonth()));
                }
                else if(this.isRange(dom.getDayOfTheMonth())) {
                    result.addAll(getIntegerListInRange(dom.getDayOfTheMonth()));
                }
                else if(this.isRepeat(dom.getDayOfTheMonth(), Regex.DAYS_OF_MONTH_REPEAT_EXPRESSION)) {
                    result.addAll(getRepeatList(dom.getDayOfTheMonth(), lowerbound, upperbound));
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    private List<Integer> getMinutes(List<Minute> minutes) {
        List<Integer> result = new ArrayList<Integer>();
        int lowerBound = 0, upperBound = 59;
        boolean found = minutes.stream()
            .anyMatch(x -> Pattern.compile(Regex.ALL_EXPRESSION).matcher(x.getMinute()).find());
        if(found) {
            for (int i = lowerBound; i < upperBound; i++) {
                result.add(i);
            }
        }
        else {
            for (Minute min : minutes) {
                if(this.isInteger(min.getMinute())) {
                    result.add(Integer.parseInt(min.getMinute()));
                }
                else if(this.isRange(min.getMinute())) {
                    result.addAll(getIntegerListInRange(min.getMinute()));
                }
                else if (this.isRepeat(min.getMinute(), Regex.MINUTES_REPEAT_EXPRESSION)){
                    result.addAll(getRepeatList(min.getMinute(), lowerBound, upperBound));
                }

            }
        }
        Collections.sort(result);
        return result;
    }


    private List<Integer> getHours(List<Hour> userInput ) {
        List<Integer> hours = new ArrayList<Integer>();
        int lowerBound = 0, upperBound = 23;
        boolean found = userInput.stream()
            .anyMatch(x -> Pattern.compile(Regex.ALL_EXPRESSION).matcher(x.getHour()).find());
        if(found) {
            for (int i = lowerBound; i < upperBound; i++) {
                hours.add(i);
            }
        }
        else {
            List<Hour> userHours= userInput;
            for (Hour h: userHours) {
                // if h can be parsed to integer
                if(this.isInteger(h.getHour())) {
                    hours.add(Integer.parseInt(h.getHour()));
                }
                else if(this.isRange(h.getHour())) {
                    hours.addAll(getIntegerListInRange(h.getHour()));
                }
                else if (this.isRepeat(h.getHour(), Regex.HOUR_REPEAT_EXPRESSION)) {
                    hours.addAll(getRepeatList(h.getHour(), lowerBound, upperBound));
                }
            }

        }
        Collections.sort(hours);
        return hours;
    }

    private boolean isRepeat(String expression, String regex) {
        return expression.matches(regex);

    }

    private static ArrayList<Integer> getRepeatList(String val, int lowerbound, int upperbound) {
        ArrayList<Integer> repeatList = new ArrayList<>();
        String broken[] =  val.split("/");
        int interval = Integer.parseInt(broken[1]);

        if(interval !=  0) {
            int iterations = (upperbound+1)/interval;
            for (int i = lowerbound ; i < lowerbound + iterations; i ++){
                repeatList.add(i * interval);
            }
        }
        return repeatList;
    }

    public boolean isInteger(String str) {
        return str.matches(Regex.INTEGER_EXPRESSION);
    }

    private boolean isRange(String expression) {
        return expression.matches(Regex.GENERIC_RANGE);
    }

    private List<Integer> getIntegerListInRange(String input) {
        String[] range = input.split("-");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        List<Integer> integerList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            integerList.add(i);
        }

        return integerList;
    }

}

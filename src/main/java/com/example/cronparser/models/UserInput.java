package com.example.cronparser.models;

import com.example.cronparser.models.corevalidation.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserInput {
    private List<Minute> minutes;

    private List<DayOfTheWeek> daysOfTheWeek;

    private List<Month> months;

    private List<DayOfTheMonth> daysOfTheMonths;

    private List<Hour> hours;

    private String command;

    public UserInput(String minutes, String hours, String daysOfTheMonths,  String months, String daysOfTheWeek, String command) throws BadRequestException {
        setMinute(minutes);
        setHour(hours);
        setMonth(months);
        setDayOfTheMonth(daysOfTheMonths);
        setDayOfTheWeek(daysOfTheWeek);
    }

    void setMinute(String minute) throws BadRequestException {
        this.minutes = new ArrayList<>();

        String minutesArr[] = minute.split(",");
        for (String min: minutesArr) {
            Minute m = new Minute();
            m.setMinute(min);
            minutes.add(m);
        }
    }

    void setDayOfTheWeek(String dayOfTheWeek) throws BadRequestException {
        this.daysOfTheWeek = new ArrayList<>();

        String daysArr[] = dayOfTheWeek.split(",");
        for (String day: daysArr) {
            DayOfTheWeek d = new DayOfTheWeek();
            d.setDayOfTheWeek(day);
            daysOfTheWeek.add(d);
        }
    }

    void setMonth(String month) throws BadRequestException {
        this.months = new ArrayList<>();

        String monthsArr[] = month.split(",");
        for (String m: monthsArr) {
            Month monthObj = new Month();
            monthObj.setMonth(m);
            months.add(monthObj);
        }
    }

    void setDayOfTheMonth(String dayOfTheMonth) throws BadRequestException {
        this.daysOfTheMonths = new ArrayList<>();

        String daysArr[] = dayOfTheMonth.split(",");
        for (String day: daysArr) {
            DayOfTheMonth d = new DayOfTheMonth();
            d.setDayOfTheMonth(day);
            daysOfTheMonths.add(d);
        }
    }

    void setHour(String hour) throws BadRequestException {
        this.hours = new ArrayList<>();

        String hoursArr[] = hour.split(",");
        for (String h: hoursArr) {
            Hour hourObj = new Hour();
            hourObj.setHour(h);
            hours.add(hourObj);
        }
    }

    void setCommand(String command) {
        this.command = command;
    }
}

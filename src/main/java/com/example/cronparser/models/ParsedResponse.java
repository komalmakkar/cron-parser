package com.example.cronparser.models;

import com.example.cronparser.constants.ResponseStrings;
import com.example.cronparser.utils.StringUtil;
import lombok.*;


import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Data
@NoArgsConstructor
public class ParsedResponse {

    List<Integer> minutes;

    List<Integer> daysOfTheWeek;

    List<Integer> months;

    List<Integer> daysOfTheMonths;

    List<Integer> hours;

    String command;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                StringUtil.addBufferWhitespace(ResponseStrings.MINUTE, ResponseStrings.COLUMN_LENGTH)
        );
        if (minutes != null) {
            for (Integer minute : minutes) {
                sb.append(minute).append(" ");
            }
        }

        sb.append("\n");


        sb.append(
                StringUtil.addBufferWhitespace(ResponseStrings.DAY_OF_THE_WEEK, ResponseStrings.COLUMN_LENGTH)

        );
        if (daysOfTheWeek != null) {
            for (Integer day : daysOfTheWeek) {
                sb.append(day).append(" ");
            }
        }
        sb.append("\n");

        sb.append(
                StringUtil.addBufferWhitespace(ResponseStrings.MONTH, ResponseStrings.COLUMN_LENGTH)
        );
        if (months != null) {
            for (Integer month : months) {
                sb.append(month).append(" ");
            }
        }
        sb.append("\n");

        sb.append(
                StringUtil.addBufferWhitespace(ResponseStrings.DAY_OF_THE_MONTH, ResponseStrings.COLUMN_LENGTH)
        );
        if (daysOfTheMonths != null) {
            for (Integer day : daysOfTheMonths) {
                sb.append(day).append(" ");
            }
        }
        sb.append("\n");

        sb.append(
                StringUtil.addBufferWhitespace(ResponseStrings.HOUR, ResponseStrings.COLUMN_LENGTH)
        );
        if (hours != null) {
            for (Integer hour : hours) {
                sb.append(hour).append(" ");
            }
        }
        sb.append("\n");

        sb.append(
                StringUtil.addBufferWhitespace(ResponseStrings.COMMAND, ResponseStrings.COLUMN_LENGTH)
        );
        sb.append(this.command);
        sb.append("\n");

        String output = sb.toString();
       
        return output;
    }

}

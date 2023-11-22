package com.example.cronparser.constants;

public class Regex {
    public static final
    String DAYS_OF_MONTH_EXPRESSION = "^(0?[1-9]|[12][0-9]|3[01])$";

    public static final
    String RANGE_OF_DAYS_OF_MONTH_EXPRESSION = "^([1-9]|1[0-9]|2[0-9]|3[01])-(?:[1-9]|1[0-9]|2[0-9]|3[01])$";

    public static final
    String DAYS_OF_MONTH_REPEAT_EXPRESSION = "^\\*/([1-9][0-9]*)$";

    public static final
    String ALL_EXPRESSION = "^\\*$";

    public static final
    String ANY_EXPRESSION = "^\\?$";

    public static final
    String DAYS_OF_THE_WEEK_NUMERIC_EXPRESSION = "^[1-7]$";

    public static final
    String DAYS_OF_THE_WEEK_NUMERIC_RANGE_EXPRESSION ="^[1-7]-(?:[1-7])$";

    public static final
    String DAYS_OF_THE_WEEK_ALIAS_EXPRESSION = "^(sun|mon|tue|wed|thu|fri|sat)$";

    public static final
    String DAYS_OF_THE_WEEK_ALIAS_RANGE_EXPRESSION = "^(sun|mon|tue|wed|thu|fri|sat)-(?:sun|mon|tue|wed|thu|fri|sat)$";

    public static final
    String HOUR_24_EXPRESSION = "^([01]?[0-9]|2[0-3])$";

    public static final
    String HOUR_24_RANGE_EXPRESSION = "^(?:[01]?[0-9]|2[0-3])-(?:[01]?[0-9]|2[0-3])$";

    public static final
    String HOUR_REPEAT_EXPRESSION = "^\\*/([1-9]|1[0-9]|2[0-3])$";

    public static final
    String MINUTES_EXPRESSION = "^(0?[0-9]|[1-5][0-9]|59)$";

    public static final
    String MINUTES_RANGE_EXPRESSION = "^(0?[6-9]|[1-4][0-9]|5[0-5]|0?[2-5])$";

    public static final
    String MINUTES_REPEAT_EXPRESSION = "^\\*/([0-9]|[1-5][0-9])$";

    public static final
    String MONTH_NUMERIC_EXPRESSION = "^(0?[1-9]|1[0-2])$";

    public static final
    String MONTH_NUMERIC_RANGE_EXPRESSION = "^(0?[1-9]|1[0-2])-(?:0?[1-9]|1[0-2])$";

    public static final
    String MONTH_ALPHA_EXPRESSION = "^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)$";

    public static final
    String MONTH_ALPHA_RANGE_EXPRESSION = "^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-(?:jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)$";

    public static final
    String MONTH_NUMERIC_REPEAT_EXPRESSION = "^\\*/(0?[1-9]|1[0-2])$";

    public static final
    String INTEGER_EXPRESSION = "\\d+";

    public static final
    String INTEGER_RANGE = "\\d+-\\d+";

    public static final
    String GENERIC_RANGE = "^.*-.*$";
}

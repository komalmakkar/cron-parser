
package com.example.cronparser.utils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
public final class StringUtil {

    public static String addBufferWhitespace(String input, int totalLen) {
        if (input.length() < totalLen) {
            int bufferLength = totalLen - input.length();
            String buffer = IntStream.range(0, bufferLength)
                    .mapToObj(i -> " ")
                    .collect(Collectors.joining());
            return input + buffer;
        }
        return input;
    }
}

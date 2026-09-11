package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question05 {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList(
                "123abc",
                "hello",
                "1apple",
                "Java",
                "2024year",
                "world",
                "9lives"
        );

        List<String> result = findStringsStartingWithNumber(strings);

        System.out.println(result);
    }

    public static List<String> findStringsStartingWithNumber(List<String> strings) {

        return strings.stream().filter(s->Character.isDigit(s.charAt(0))).toList();

    }
}

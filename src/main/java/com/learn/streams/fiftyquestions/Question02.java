package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question02 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 25, 11, 45, 123, 56, 19, 210, 100, 7
        );

        List<Integer> result = findNumbersStartingWithOne(numbers);

        System.out.println(result);
    }

    public static List<Integer> findNumbersStartingWithOne(List<Integer> numbers) {
       return numbers.stream().filter(integer ->  String.valueOf(integer).startsWith("1")).toList();
    }
}

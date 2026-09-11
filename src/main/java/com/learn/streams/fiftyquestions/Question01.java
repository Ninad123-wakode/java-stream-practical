package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question01 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 30, 50
        );

        List<Integer> result = removeDuplicates(numbers);

        System.out.println(result);
    }

    public static List<Integer> removeDuplicates(List<Integer> numbers) {

        return numbers.stream().distinct().toList();
    }
}
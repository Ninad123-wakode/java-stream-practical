package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question21 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 15, 20, 25, 30, 35, 40, 45
        );

        Map<Boolean, List<Integer>> result = partitionEvenOdd(numbers);

        System.out.println(result);
    }

    public static Map<Boolean, List<Integer>> partitionEvenOdd(
            List<Integer> numbers) {

        return numbers.stream().collect(Collectors.partitioningBy(integer -> integer%2==0));
    }
}

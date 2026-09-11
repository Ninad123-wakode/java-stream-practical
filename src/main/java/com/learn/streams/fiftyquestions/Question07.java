package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question07 {
    public static void main(String[] args) {

        List<Double> numbers = Arrays.asList(
                10.5, 3.2, 8.7, 15.1, 2.9, 7.4
        );

        List<Double> result = sortInReverseOrder(numbers);

        System.out.println(result);
    }

    public static List<Double> sortInReverseOrder(List<Double> numbers) {

      return   numbers.stream().sorted(Comparator.reverseOrder()).toList();
     }
}

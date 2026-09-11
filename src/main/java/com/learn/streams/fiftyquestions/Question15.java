package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Find the minimum, maximum, sum, average, and count of numbers from a given list using Java Streams.
 */
public class Question15 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 25, 5, 40, 15, 30
        );
        calculateStatistics(numbers);
    }

    public static void calculateStatistics(List<Integer> numbers) {
        int sum = numbers.stream().reduce((a, b)-> a+b).get();
        System.out.println("Sum:- " + sum);

        int minimum = numbers.stream().sorted().findFirst().get();
        System.out.println("minimum:- " + minimum);

        int maximum = numbers.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("maximum:- " + maximum);

        int average = (int) numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("average:- " + average);

        int count = (int) numbers.stream().mapToInt(Integer::intValue).count();
        System.out.println("count:- " + count);


    }
}

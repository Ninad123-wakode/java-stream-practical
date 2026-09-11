package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.OptionalInt;

public class Question08 {
    public static void main(String[] args) {

        int[] numbers = {7, 2, 10, 4, 3, 8, 1, 6};

        int n = 7;

        OptionalInt result = findNthSmallest(numbers, n);

        result.ifPresent(System.out::println);
    }

    public static OptionalInt findNthSmallest(int[] numbers, int n) {
       return Arrays.stream(numbers).sorted().skip(n-1).findFirst();
    }
}

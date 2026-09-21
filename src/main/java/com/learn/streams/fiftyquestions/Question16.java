package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question16 {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 20, 50};

        boolean result = containsDuplicates(numbers);

        System.out.println(result);
    }

    public static boolean containsDuplicates(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(numbers).boxed().anyMatch(num -> !set.add(num));
    }
}
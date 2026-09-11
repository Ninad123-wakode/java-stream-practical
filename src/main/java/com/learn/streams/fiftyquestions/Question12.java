package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question12 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 50, 30
        );

        Integer result = sumUniqueNumbers(numbers);

        System.out.println(result);
    }

    public static Integer sumUniqueNumbers(List<Integer> numbers) {

       // return numbers.stream().distinct().reduce((a,b)->a+b).get();
    return numbers.stream().distinct().mapToInt(Integer::intValue).sum();
    }
}

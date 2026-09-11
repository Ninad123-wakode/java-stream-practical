package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question11 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 20, 30, 40, 50
        );

        Integer result = sumFirstTwo(numbers);

        System.out.println(result);
    }

    public static Integer sumFirstTwo(List<Integer> numbers) {
//        return numbers.stream().limit(2).mapToInt(Integer::intValue).sum();
        return numbers.stream().limit(2).reduce((a,b)->a+b).get();
    }
}

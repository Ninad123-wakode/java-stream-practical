package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question18 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 24, 18, 7, 12, 15, 21
        );

        Optional<Integer> result = findFirstOdd(numbers);

        System.out.println(result);
    }

    public static Optional<Integer> findFirstOdd(List<Integer> numbers) {
        return numbers.stream().filter(integer -> integer%2 != 0).findFirst();
    }
}

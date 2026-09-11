package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Question09 {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        Optional<Integer> result = findLastElement(numbers);

        System.out.println(result);
    }

    public static Optional<Integer> findLastElement(int[] numbers) {
//        return  Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).findFirst();
        return  Arrays.stream(numbers).boxed().skip(numbers.length-1).findFirst();


    }
}

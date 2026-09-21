package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Question19 {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(
                10, 20, 30, 40, 50
        );

        List<Integer> list2 = Arrays.asList(
                30, 40, 50, 60, 70
        );

        List<Integer> result = findIntersection(list1, list2);

        System.out.println(result);
    }

    public static List<Integer> findIntersection(
            List<Integer> list1,
            List<Integer> list2) {

       return list1.stream().filter(list2::contains).toList();


    }
}

package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Question03 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(6, 5, 3);
        List<Integer> list2 = Arrays.asList(4, 2, 1);

        System.out.println(joinStreams(list1,list2));
    }

    private static List<Integer> joinStreams(List<Integer> list1, List<Integer> list2) {
      return Stream.concat(list1.stream(), list2.stream()).sorted().toList();
    }
}

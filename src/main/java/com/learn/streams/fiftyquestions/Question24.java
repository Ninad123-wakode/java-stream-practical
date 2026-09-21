package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question24 {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "java", "spring", "java", "kafka",
                "spring", "java", "docker", "kafka"
        );

        Map<String, Long> result = countElements(words);

        System.out.println(result);
    }

    public static Map<String, Long> countElements(List<String> words) {

        return words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}

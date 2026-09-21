package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question17 {

        public static void main(String[] args) {

            String str = "programming";

            System.out.println(printCharacterCount(str));
        }

        public static Map<String, Long> printCharacterCount(String str) {
           return Arrays.stream(str.replace(" ", "").
                             split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }
}

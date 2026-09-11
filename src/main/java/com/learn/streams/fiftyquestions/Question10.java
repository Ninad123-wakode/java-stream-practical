package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Question10 {
       public static void main(String[] args) {

            List<String> strings = Arrays.asList(
                    "Java",
                    "Spring",
                    "Kafka",
                    "Docker"
            );

            String result = joinStrings(strings);

            System.out.println(result);
        }

        public static String joinStrings(List<String> strings) {
//         return strings.stream().map(word->"["+word+"]").collect(Collectors.joining(","));
            return strings.stream().collect(Collectors.joining(",", "[", "]"));
        }

}

package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Question14 {
    public static void main(String[] args) {

        String str = "swiss";

        Character result = findFirstNonRepeatedCharacter(str);

        System.out.println(result);
    }

    public static Character findFirstNonRepeatedCharacter(String str) {
        return str.chars()
                .mapToObj(c->(char)c)
                  .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
                  .entrySet().stream().filter(entry->entry.getValue()==1)
                  .map(entry->entry.getKey())
                  .findFirst().get();

    }
}

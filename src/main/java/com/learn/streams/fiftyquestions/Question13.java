package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question13 {
        public static void main(String[] args) {

            String sentence = "Java streams are powerful and useful";

            int k = 2;

            List<String> result = findWordsWithKVowels(sentence, k);

            System.out.println(result);
        }

        public static List<String> findWordsWithKVowels(String sentence, int k) {

            return Arrays.stream(sentence.split(" ")).filter(word->
                                                                            word.chars()
                                                                                .filter(c->"aeiouAEIOU".indexOf(c)!=-1)
                                                                                .count()==k)
                                                                            .toList();
        }
}

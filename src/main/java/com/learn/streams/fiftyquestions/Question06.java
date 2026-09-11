package com.learn.streams.fiftyquestions;

import java.util.stream.IntStream;

public class Question06 {
    public static void main(String[] args) {

        String str = "madam";

        boolean result = isPalindrome(str);

        System.out.println(result);
    }

    public static boolean isPalindrome(String str) {
        return IntStream.range(0,str.length()/2).allMatch(i->str.charAt(i)==str.charAt(str.length()-1-i));

    }
}

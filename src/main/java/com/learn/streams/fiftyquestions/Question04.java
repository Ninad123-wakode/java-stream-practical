package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question04 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                35, 29, 4, 8, 15, 21, 25
        );

        boolean result = containsPrimeNumber(numbers);

        System.out.println(result);
    }

    public static boolean containsPrimeNumber(List<Integer> numbers) {

        return numbers.stream().anyMatch(Question04::isPrme);
    }
    public static boolean isPrme(int num){
        if (num<=1) return false;
        for (int i =2; i<Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}

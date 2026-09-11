package com.learn.streams.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
int[] arr = new int[]{2,3,2,5,6,5};

 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,2,5,6,5};
        List<Integer> list =new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr){
            if(!set.add(i)){
                list.add(i);
            }
        }
    }
}

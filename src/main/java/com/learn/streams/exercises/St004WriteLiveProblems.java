package com.learn.streams.exercises;

import com.learn.streams.model.Employee;
import com.learn.streams.model.Item;
import com.learn.streams.model.Order;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given a List<String> of words, find word frequency count (Map<String, Long>) — classic, always asked
Find the first non-repeated character in a string using streams
Given a List<Order> with List<Item> each, flatten to get total revenue across all items (nested flatMap + sum)
Find duplicate elements in a list using streams
Convert a List<Employee> into a String like "Alice(HR), Bob(IT)" using Collectors.joining() with prefix/suffix/delimiter
 */
public class St004WriteLiveProblems {
    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Employee> employees = List.of(
                new Employee("E1", "Alice", "IT", "SENIOR", 85000),
                new Employee("E2", "Bob", "IT", "MID", 65000),
                new Employee("E3", "Charlie", "HR", "JUNIOR", 40000),
                new Employee("E4", "Diana", "HR", "SENIOR", 75000),
                new Employee("E5", "Eve", "Finance", "MID", 60000),
                new Employee("E6", "Frank", "IT", "JUNIOR", 45000),
                new Employee("E7", "Grace", "Finance", "SENIOR", 90000)
        );


            List<Item> items1 = Arrays.asList(
                    new Item("Laptop", 1, 75000),
                    new Item("Mouse", 2, 1500),
                    new Item("Keyboard", 1, 3000)
            );

            List<Item> items2 = Arrays.asList(
                    new Item("Monitor", 2, 15000),
                    new Item("Headphones", 1, 5000)
            );

            List<Order> orders = Arrays.asList(
                    new Order("ORD001", items1),
                    new Order("ORD002", items2)
            );

            List<String> list1 = Arrays.asList("ninad", "ninad", "shivu", "shivu", "shivu","sanchit");


        List<Integer> input2 = Arrays.asList(1, 2, 3);

    //  System.out.println(findWordFrequencyCount(list1));
    // System.out.println(firstNonRepeatedCharacter("ninadshivani"));
    //  System.out.println(totalRevenueAcrossAllItems(orders));
   // System.out.println(findDeuplicates(list1));
        System.out.println(convertListToString(employees));

    }

    private static List<String> convertListToString(List<Employee> employees) {
       return employees.stream().map(e -> e.getName()+e.getDepartment()).toList();
    }

    private static Set<String> findDeuplicates(List<String> list1) {
        Set<String> seen = new HashSet<>();
        return  list1.stream()
                                         .filter(n -> !seen.add(n))
                                         .collect(Collectors.toSet());
    }

    private static double totalRevenueAcrossAllItems(List<Order> orders) {
       return orders.stream().flatMap(order -> order.getItems().stream())
                .mapToDouble(item->item.getQuantity()*item.getPrice())
                .sum();
    }
    

    private static Character firstNonRepeatedCharacter(String str) {
          return  str.chars().mapToObj(c->(char)c)
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream().filter(e->e.getValue()==1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElseThrow();


    }

    private static Map<String, Long> findWordFrequencyCount(List<String> input) {
      return   input.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}

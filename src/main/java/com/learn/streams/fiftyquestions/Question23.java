package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question23 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", 30),
                new Employee("Amit", 25),
                new Employee("Priya", 30),
                new Employee("Sneha", 25),
                new Employee("Vikas", 28)
        );

        List<Employee> result = sortEmployees(employees);

        result.forEach(System.out::println);
    }

    public static List<Employee> sortEmployees(List<Employee> employees) {

     return   employees.stream().sorted(Comparator.comparingInt((Employee emp) -> emp.age)
                                           .thenComparing((Employee emp)-> emp.name)).toList();



    }

    static class Employee {

        String name;
        int age;

        Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }
}

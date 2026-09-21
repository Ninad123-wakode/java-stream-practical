package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Question20 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", 25),
                new Employee("Amit", 30),
                new Employee("Priya", 25),
                new Employee("Sneha", 28),
                new Employee("Vikas", 30),
                new Employee("Neha", 28)
        );

        Map<Integer, List<Employee>> result = groupByAge(employees);

        result.forEach((age, employeeList) ->
                System.out.println(age + " -> " + employeeList)
        );
    }

    public static Map<Integer, List<Employee>> groupByAge(
            List<Employee> employees) {

       return employees.stream().collect(Collectors.groupingBy(employee ->employee.age));


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
            return name;
        }
    }
}

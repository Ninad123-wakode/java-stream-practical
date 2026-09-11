package com.learn.streams.exercises;

import com.learn.streams.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Set 1: Core Collectors (must be instant recall)
Group a List<Employee> by department, get count per department
Group by department, but get List<String> of employee names per department (not full objects)
Group by department AND then by seniority level (nested grouping → Map<String, Map<String, List<Employee>>>)
 */
public class St001Core {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("E1", "Alice", "IT", "SENIOR", 85000),
                new Employee("E2", "Bob", "IT", "MID", 65000),
                new Employee("E3", "Charlie", "HR", "JUNIOR", 40000),
                new Employee("E4", "Diana", "HR", "SENIOR", 75000),
                new Employee("E5", "Eve", "Finance", "MID", 60000),
                new Employee("E6", "Frank", "IT", "JUNIOR", 45000),
                new Employee("E7", "Grace", "Finance", "SENIOR", 90000)
        );

        //   System.out.println(getCountPerDepartment(employees));
        // System.out.println(getNamesPerDepartment(employees));
        System.out.println(getNamesPerDepartmentPerSeniority(employees));

    }

    private static Map<String, Map<String, List<String>>> getNamesPerDepartmentPerSeniority(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.groupingBy(Employee::getSeniorityLevel, Collectors.mapping(Employee::getName,
                        Collectors.toList()))));
    }

    private static Map<String, List<String>> getNamesPerDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));
    }

    public static Map<String, Long> getCountPerDepartment(List<Employee> employees) {
        Map<String, Long> countByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.counting()));
        return countByDept;
    }


}

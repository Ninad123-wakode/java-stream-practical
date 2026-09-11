package com.learn.streams.exercises;

import com.learn.streams.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Find average salary per department
Find the highest-paid employee per department (Collectors.groupingBy + Collectors.maxBy)
Partition employees into two groups: salary > 50000 and salary <= 50000 (Collectors.partitioningBy)
Convert List<Employee> to Map<String, Employee> keyed by employee ID — and handle the duplicate-key merge case
 */
public class St002Core {
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

        //  System.out.println(findAvrageSalPerDepartment(employees));
        //  System.out.println(getHighestPaidPerDepartment(employees));
        //    System.out.println(PartitionEmployeesIntoTwoGroups(employees));
        System.out.println(ListToMap(employees));
    }

    private static Map<String, Employee> ListToMap(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity(), (existing,
                                                                                                  replacement) -> existing));
    }

    private static Map<Boolean, List<Employee>> PartitionEmployeesIntoTwoGroups(List<Employee> employees) {
        return employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
    }

    private static Map<String, Optional<Employee>> getHighestPaidPerDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    private static Map<String, Double> findAvrageSalPerDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
    }


}

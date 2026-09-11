package com.learn.streams.exercises;

import com.learn.streams.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Explain and demonstrate the difference between map() and flatMap() — write code that flattens List<List<Integer>>
into a single sorted, distinct List<Integer>

Show why streams are lazy — write a stream pipeline with a peek() and explain why nothing prints until a terminal
operation runs

Demonstrate why reusing a stream (calling a terminal op twice on the same stream) throws IllegalStateException

Explain reduce() with identity vs without identity, and when reduce on a parallel stream can give wrong/different
results if the combiner isn't associative

Write custom sorting: sort employees by department (asc) then salary (desc) using Comparator.comparing().thenComparing()
 */
public class St003Gotchas {

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

        List<Integer> input2 = Arrays.asList(1, 2, 3);

        //  System.out.println(mapVsFlatMap(input));
        //  LazinessWithPeek(input2);
        //  System.out.println(reusingStream(input2));
        System.out.println(sortEmployeesByDepartmentThenSalary(employees));

    }

    private static List<Employee> sortEmployeesByDepartmentThenSalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary, Comparator.reverseOrder())).toList();

    }

    private static boolean reusingStream(List<Integer> input2) {
        // nothing prints yet — no terminal op called
        input2.stream().count();
        //.count():  // throws IllegalStateException: stream has already been operated upon or closed
        return true;

        /*
        A stream is a one-shot pipeline over a source, not a reusable collection. Once a terminal op consumes it,
        it's closed. If you need to run it again, create a new stream from the source.
         */
    }

    /*
    Intermediate operations (map, filter, peek) just build a pipeline description. Nothing runs until a terminal op
    (forEach, collect, reduce...) triggers it — and even then, elements are pulled one at a time through the whole
    pipeline, not processed stage-by-stage across the whole collection.
     */
    private static void LazinessWithPeek(List<Integer> input) {
        input.stream().peek(x -> System.out.println("peeking :" + x))
             .filter(x -> x > 1)
             // nothing prints yet — no terminal op called
             .forEach(System.out::println); // NOW peek + filter execute, element by element
    }

    /*
    map() would give you Stream<List<Integer>> — one element per inner list. flatMap() unwraps each inner stream and
    merges them into a single flat Stream<Integer>. Rule of thumb: use flatMap whenever your mapper function itself
    returns a stream/collection.
     */
    private static List<Integer> mapVsFlatMap(List<List<Integer>> input) {
        return input.stream().flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
    }


}

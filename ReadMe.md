# Java Streams — Interview Practice Exercises (7 YOE)

Self-contained practice set for Streams-focused interview prep. Solve each, then verify against expected interview-level answers.

## Data Model

```java
public class Employee {
    private String id;
    private String name;
    private String department;
    private String seniorityLevel; // "JUNIOR", "MID", "SENIOR"
    private double salary;

    // constructor, getters, setters
}

public class Item {
    private String name;
    private int quantity;
    private double price;
}

public class Order {
    private String orderId;
    private List<Item> items;
}
```

## Sample Data

```java
List<Employee> employees = List.of(
    new Employee("E1", "Alice", "IT", "SENIOR", 85000),
    new Employee("E2", "Bob", "IT", "MID", 65000),
    new Employee("E3", "Charlie", "HR", "JUNIOR", 40000),
    new Employee("E4", "Diana", "HR", "SENIOR", 75000),
    new Employee("E5", "Eve", "Finance", "MID", 60000),
    new Employee("E6", "Frank", "IT", "JUNIOR", 45000),
    new Employee("E7", "Grace", "Finance", "SENIOR", 90000)
);
```

---

## Set 1: Core Collectors (must be instant recall)

1. Group a `List<Employee>` by department, get count per department
2. Group by department, but get `List<String>` of employee names per department (not full objects)
3. Group by department AND then by seniority level (nested grouping → `Map<String, Map<String, List<Employee>>>`)
4. Find average salary per department
5. Find the highest-paid employee per department (`Collectors.groupingBy` + `Collectors.maxBy`)
6. Partition employees into two groups: salary > 50000 and salary <= 50000 (`Collectors.partitioningBy`)
7. Convert `List<Employee>` to `Map<String, Employee>` keyed by employee ID — and handle the duplicate-key merge case

## Set 2: Common Gotchas Interviewers Love to Probe

8. Explain and demonstrate the difference between `map()` and `flatMap()` — write code that flattens `List<List<Integer>>` into a single sorted, distinct `List<Integer>`
9. Show why streams are lazy — write a stream pipeline with a `peek()` and explain why nothing prints until a terminal operation runs
10. Demonstrate why reusing a stream (calling a terminal op twice on the same stream) throws `IllegalStateException`
11. Explain `reduce()` with identity vs without identity, and when `reduce` on a parallel stream can give wrong/different results if the combiner isn't associative
12. Write custom sorting: sort employees by department (asc) then salary (desc) using `Comparator.comparing().thenComparing()`

## Set 3: Real "Write It Live" Interview Problems

13. Given a `List<String>` of words, find word frequency count (`Map<String, Long>`) — classic, always asked
14. Find the first non-repeated character in a string using streams
15. Given a `List<Order>` with `List<Item>` each, flatten to get total revenue across all items (nested flatMap + sum)
16. Find duplicate elements in a list using streams
17. Convert a `List<Employee>` into a `String` like `"Alice(HR), Bob(IT)"` using `Collectors.joining()` with prefix/suffix/delimiter

## Set 4: Custom Collector (Senior-Level Differentiator)

18. Write your own custom `Collector` using `Collector.of(...)` instead of relying on built-in ones — e.g., collect into a custom summary object holding count+sum+average in one pass
19. Explain when you'd use `Collectors.teeing()` (Java 12+) to get two different aggregations in a single pass over a stream

---

## How to Use This

- Solve each exercise on paper or IDE without looking up Collectors docs first — simulate interview pressure
- For Set 2, be ready to *explain* the behavior out loud, not just write code — these are usually verbal/whiteboard questions
- Set 4 is what separates mid-level from senior candidates — don't skip it
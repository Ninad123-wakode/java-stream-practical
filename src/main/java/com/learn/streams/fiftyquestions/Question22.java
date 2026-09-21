package com.learn.streams.fiftyquestions;

import java.util.Arrays;
import java.util.List;

public class Question22 {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Rahul", 20),
                new Student("Priya", 22),
                new Student("Amit", 21),
                new Student("Sneha", 23),
                new Student("Vikas", 24)
        );

        double result = calculateAverageAge(students);

        System.out.println(result);
    }

    public static double calculateAverageAge(List<Student> students) {

        return students.stream().mapToInt(student->student.age).average().getAsDouble();
    }

    static class Student {

        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

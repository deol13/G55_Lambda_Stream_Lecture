package se.lexicon.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] arr = {1,1,2,2,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> numbers = new ArrayList<>(List.of(arr));

        Predicate<Integer> evenNumber = num -> num % 2 == 0;
        Predicate<Integer> numberGreaterThan5 = num -> num > 5;
        Consumer<Integer> printNumber = num -> System.out.println(num);

        numbers.stream() // converts the collection into a stream pipeline
                .filter(num -> num % 2 == 0) //intermediate operation: can chain each other
                .filter(num -> num > 5)
                .forEach(System.out::println); // terminal operation: can't be chained
        numbers.stream()
                .filter(evenNumber)
                .filter(numberGreaterThan5)
                .forEach(printNumber);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct() //intermediate operation
                .toList(); // terminal operation
        System.out.println(numbers);
        System.out.println(distinctNumbers);


        System.out.println("-------------------------");

        employees.addAll(Arrays.asList(
           new Employee("Alice", "Engineering", 30, 60000),
           new Employee("Bob", "Engineering", 35, 70000),
           new Employee("Charlie", "HR", 28, 45000),
           new Employee("David", "HR", 40, 50000),
           new Employee("Eve", "Finance", 32, 65000),
           new Employee("Frank", "Finance", 25, 55000),
           new Employee("Grace", "Engineering", 45, 80000)
        ));

        // To find employees in the "Engineering" department earning more than 60k
        // step 1; create stream
        // step 2 use intermediate operation to create a new filter stream
        // step 3: use terminal operation to create result
        List<Employee> list = employees.stream()
                .filter(employee -> employee.getDepartment().equals("Engineering") && employee.getSalary() > 60000)
                .toList();

        list.forEach(employee -> System.out.println(employees));

        // Find employees names sorted by salary
        List<String> names = employees.stream()
                .sorted(Comparator.comparingDouble(employee -> employee.getSalary())) // Employee::getSalary
                .map(employee -> employee.getName()) // Employee::getName
                .toList();

        names.forEach(System.out::println); // method reference
    }
}

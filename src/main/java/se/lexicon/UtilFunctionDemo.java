package se.lexicon;

import java.util.Random;
import java.util.function.*;

public class UtilFunctionDemo {
    public static void main(String[] args) {
        // Function<String , String>
        // R apply(T)
        // Integer apply(String)
        System.out.println("R apply(T)");
        Function<String, Integer> stringToLength = str -> str.length();
        System.out.println(stringToLength.apply("Hello Java!"));
        Function<Double, Double> fahrenheitToCelsius = f -> (f - 32) * 5 / 9;
        System.out.println(fahrenheitToCelsius.apply(100.0));

        // if the parameter type and return type is the same you can use UnaryOperator.
        UnaryOperator<Double> fahrenheitToCelsius2 = f -> (f - 32) * 5 / 9;
        System.out.println(fahrenheitToCelsius2.apply(100.0));


        // Predicate<> return type is always boolean
        System.out.println("\nPredicate<T>");
        System.out.println("isEven:");
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(5));
        System.out.println(isEven.test(6));
        Predicate<Integer> isPositive = num -> num > 0;

        System.out.println("isGreaterThan100:");
        Predicate<Integer> isGreaterThan100 = num -> num > 100;
        System.out.println(isGreaterThan100.test(99));
        System.out.println(isGreaterThan100.test(150));

        System.out.println("isPositiveAndEven:");
        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
        Predicate<Integer> isPositiveAndEven2 = num -> isPositive.test(num) && isEven.test(num);
        System.out.println(isPositiveAndEven2.test(200));
        System.out.println(isPositiveAndEven2.test(199));
        System.out.println(isPositiveAndEven2.test(-200));

        System.out.println("Consumer<T>"); // Doesn't return anything
        Consumer<Todo> printSummary = task -> System.out.println("Title: " + task.getTitle() + " | " + task.isCompleted());
        printSummary.accept(new Todo("Task name", true, 2));

        System.out.println("Supplier<T>"); // Doesn't have a parameter, the T is the return type.
        // () is a must if there are no parameters
        Supplier<Integer> generateNumber = () -> new Random().nextInt(100);
        System.out.println(generateNumber.get());
    }
}

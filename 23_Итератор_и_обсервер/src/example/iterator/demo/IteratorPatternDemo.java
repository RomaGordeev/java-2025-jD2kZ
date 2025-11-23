package example.iterator.demo;

import example.iterator.ArrayListWrapper;
import example.iterator.MyIterator;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Demonstration of custom iterator from scratch ===\n");

        // Create wrapper and add elements
        ArrayListWrapper<String> wrapper = new ArrayListWrapper<>();
        wrapper.add("Java");
        wrapper.add("Python");
        wrapper.add("JavaScript");
        wrapper.add("C++");
        wrapper.add("Go");

        System.out.println("1. Basic iterator:");
        MyIterator<String> iterator = wrapper.getIterator();
        while (iterator.hasNext()) {
            String language = iterator.next();
            System.out.println("  Language: " + language);

            if ("Python".equals(language)) {
                iterator.remove();
                System.out.println("    -> Python removed through iterator");
            }
        }

        System.out.println("\n2. State after removal:");
        MyIterator<String> iterator2 = wrapper.getIterator();
        while (iterator2.hasNext()) {
            System.out.println("  Remaining: " + iterator2.next());
        }

        System.out.println("\n5. forEach demonstration on collection:");
        wrapper.forEach(language -> System.out.println("  Processing: " + language.toUpperCase()));

        System.out.println("\n6. Exception handling demonstration:");
        MyIterator<String> testIterator = wrapper.getIterator();

        try {
            testIterator.remove(); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("  Caught exception: " + e.getMessage());
        }

        // Correct usage
        testIterator.next(); // OK
        testIterator.remove(); // OK

        try {
            testIterator.remove(); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("  Caught exception: " + e.getMessage());
        }

        // Reach the end
        while (testIterator.hasNext()) {
            testIterator.next();
        }

        try {
            testIterator.next(); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("  Caught exception: " + e.getMessage());
        }

        System.out.println("\n7. Collection size: " + wrapper.size());
        System.out.println("   Is collection empty: " + wrapper.isEmpty());

        // Additional forEach examples
        System.out.println("\n8. Advanced forEach examples:");

        ArrayListWrapper<Integer> numbers = new ArrayListWrapper<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.print("   Numbers: ");
        numbers.forEach(num -> System.out.print(num + " "));

        System.out.print("\n   Even numbers: ");
        numbers.forEach(num -> {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        });

        System.out.println("\n\n9. Using forEach with different iterators via collection methods:");
        System.out.print("   Regular order: ");
        wrapper.forEach(lang -> System.out.print(lang + " "));
    }
}
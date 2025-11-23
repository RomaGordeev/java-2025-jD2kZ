package com.examples.iterator;

import java.util.*;

public class IteratorExample5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jane", "Heidi", "Hannah", "John", "Alice");

        // Example 1: Basic usage with lambda
        System.out.println("\n1. Basic forEachRemaining with lambda:");
        Iterator<String> iterator1 = names.iterator();
        iterator1.forEachRemaining(name -> {
            System.out.println("  " + name);
        });

        System.out.println("===");

        // Example 2: Method reference (cleaner for simple operations)
        System.out.println("\n2. forEachRemaining with method reference:");
        Iterator<String> iterator2 = names.iterator();
        iterator2.forEachRemaining(System.out::println);
    }
}

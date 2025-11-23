package com.examples.listiterator;

import java.util.*;

public class ListIteratorExample1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Cherry");
        list.add("Date");

        ListIterator<String> iterator = list.listIterator();

        // 1. hasNext() and next()
        System.out.println("\n1. Forward iteration:");
        while (iterator.hasNext()) {
            int nextIndex = iterator.nextIndex();
            String element = iterator.next();
            System.out.println("  Next index: " + nextIndex + ", Element: " + element);
        }

        // 2. hasPrevious() and previous()
        System.out.println("\n2. Backward iteration:");
        while (iterator.hasPrevious()) {
            int prevIndex = iterator.previousIndex();
            String element = iterator.previous();
            System.out.println("  Previous index: " + prevIndex + ", Element: " + element);
        }

        // 3. add() method
        System.out.println("\n3. Adding elements:");
        iterator = list.listIterator(); // Reset iterator
        iterator.next(); // Move to "Apple"
        iterator.add("Banana"); // Add before "Apple"
        System.out.println("  Added 'Banana' before 'Apple'");
        System.out.println("  List after add: " + list);

        // 4. set() method
        iterator.next(); // Move to "Apple"
        iterator.set("Apricot"); // Replace "Apple" with "Apricot"
        System.out.println("\n4. Setting elements:");
        System.out.println("  Replaced 'Apple' with 'Apricot'");
        System.out.println("  List after set: " + list);

        // 5. remove() method
        System.out.println("\n5. Removing elements:");
        iterator.next(); // Move to "Cherry"
        iterator.remove(); // Remove "Cherry"
        System.out.println("  Final list: " + list);
    }
}
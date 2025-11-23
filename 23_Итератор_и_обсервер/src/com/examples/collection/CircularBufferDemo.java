package com.examples.collection;

import java.util.*;

public class CircularBufferDemo {
    public static void main(String[] args) {
        System.out.println("=== Circular Buffer Demo ===");

        // Create a circular buffer with capacity 3
        CircularBuffer<String> buffer = new CircularBuffer<>(3);

        System.out.println("1. Adding elements:");
        buffer.add("First");
        buffer.add("Second");
        buffer.add("Third");
        System.out.println("   Buffer: " + buffer);
        System.out.println("   Size: " + buffer.size() + ", Capacity: " + buffer.capacity());
        System.out.println("   Is full? " + buffer.isFull());

        System.out.println("\n2. Adding fourth element (overwrites oldest):");
        buffer.add("Fourth");
        System.out.println("   Buffer: " + buffer);
        System.out.println("   Notice 'First' was overwritten!");

        System.out.println("\n3. Using iterator to traverse:");
        System.out.print("   ");
        for (String element : buffer) {
            System.out.print(element + " → ");
        }
        System.out.println("END");

        System.out.println("\n4. Removing elements:");
        System.out.println("   Removed: " + buffer.remove());
        System.out.println("   Removed: " + buffer.remove());
        System.out.println("   Buffer after removals: " + buffer);
        System.out.println("   Size: " + buffer.size() + ", Is empty? " + buffer.isEmpty());

        System.out.println("\n5. Adding more elements:");
        buffer.add("Fifth");
        buffer.add("Sixth");
        System.out.println("   Buffer: " + buffer);

        System.out.println("\n6. Manual iterator usage:");
        Iterator<String> iterator = buffer.iterator();
        while (iterator.hasNext()) {
            System.out.println("   - " + iterator.next());
        }

        System.out.println("\n7. Clear and check:");
        buffer.clear();
        System.out.println("   Buffer after clear: " + buffer);
        System.out.println("   Is empty? " + buffer.isEmpty());
    }
}
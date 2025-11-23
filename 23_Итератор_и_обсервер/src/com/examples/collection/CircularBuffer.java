package com.examples.collection;

import java.util.*;

/**
 * A simple circular buffer implementation that overwrites oldest elements when full
 * This is not available in standard Java Collections
 */

public class CircularBuffer<T> implements Iterable<T> {
    private T[] buffer;
    private int head; // Read position
    private int tail; // Write position
    private int size; // Current number of elements
    private final int capacity;

    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Add element to the buffer (overwrites oldest if full)
    public void add(T element) {
        buffer[tail] = element;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Move head forward, overwriting oldest
        }
    }

    // Remove and return the oldest element
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Buffer is empty");
        }
        T element = buffer[head];
        buffer[head] = null; // Help garbage collection
        head = (head + 1) % capacity;
        size--;
        return element;
    }

    // Peek at the oldest element without removing
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Buffer is empty");
        }
        return buffer[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void clear() {
        Arrays.fill(buffer, null);
        head = 0;
        tail = 0;
        size = 0;
    }

    // Implement Iterable interface
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            private int count = 0;

            {
                // Initialize current to head for the first iteration
                current = head;
            }

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = buffer[current];
                current = (current + 1) % capacity;
                count++;
                return element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not supported in circular buffer iterator");
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "CircularBuffer[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("CircularBuffer[");

        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
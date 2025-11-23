package com.examples.iterator;

import java.util.*;

public class IteratorExample4 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Jane");
        list.add("Heidi");
        list.add("Hannah");

        Iterator<String> iterator1 = list.iterator();
        while(iterator1.hasNext()) {
            System.out.println( iterator1.next() );
            list.remove(list.size() - 1); // следующая итерация выкинет ConcurrentModificationException
        }

        list.remove(list.size() - 1);

        Iterator<String> iterator2 = list.iterator();
        while(iterator2.hasNext()) {
            System.out.println( iterator2.next() );
        }

        list.add("Hannah");

        Iterator<String> iterator3 = list.iterator();
        while(iterator3.hasNext()) {
            System.out.println( iterator3.next() );
            iterator3.remove();
        }

    }
}

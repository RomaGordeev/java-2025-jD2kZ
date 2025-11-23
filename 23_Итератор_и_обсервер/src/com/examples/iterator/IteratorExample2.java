package com.examples.iterator;

import java.util.*;

public class IteratorExample2 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Jane");
        list.add("Heidi");
        list.add("Hannah");

        Iterator<String> iterator1 = list.iterator();
        while(iterator1.hasNext()) {
            System.out.println( iterator1.next() );
        }

        Set<String> set = new HashSet<>();
        set.add("Jane");
        set.add("Heidi");
        set.add("Hannah");

        Iterator<String> iterator2 = set.iterator();
        while(iterator2.hasNext()) {
            System.out.println( iterator2.next() );
        }
    }
}

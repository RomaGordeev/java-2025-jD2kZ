package com.examples.iterator;

import java.util.*;

public class IteratorExample3 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Jane");
        list.add("Heidi");
        list.add("Hannah");

        Iterator<String> iterator1 = list.iterator();
        while(iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println( next );
        }

        List list2 = new ArrayList();
        list2.add("Jane");

        Iterator iterator2 = list2.iterator();
        while(iterator2.hasNext()) {
            String next = (String) iterator2.next(); // приходится делать каст
        }
    }
}

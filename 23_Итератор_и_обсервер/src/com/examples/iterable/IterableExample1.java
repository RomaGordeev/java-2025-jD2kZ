package com.examples.iterable;

import java.util.*;

public class IterableExample1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Collection<String> collection = list; // кастим лист в коллекцию
        Iterable<String> iterable = collection; // кастим коллекцию в итерабл
        // можно было сразу кастить в итерабл либо в цикле ниже прямо использовать лист вместо итерабл
        // потому что классы связаны


        // как минимум 3 способа обойти итерабл

        for(String element: iterable) { // for(String element: list) {
            System.out.println( element );
        }

        Iterator<String> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
        }

        iterable.forEach((element) -> System.out.println( element ));
    }
}

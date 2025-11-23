package com.examples.iterator;

import java.util.*;

public class IteratorExample1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Jane");
        list.add("Heidi");
        list.add("Hannah");

        Iterator<String> iterator1 = list.iterator();

        Set<String> set = new HashSet<>();
        set.add("Jane");
        set.add("Heidi");
        set.add("Hannah");

        Iterator<String> iterator2 = set.iterator();

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        Iterator<String> keyIterator = map.keySet().iterator();
        Iterator<String> valueIterator = map.values().iterator();

        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();
    }
}
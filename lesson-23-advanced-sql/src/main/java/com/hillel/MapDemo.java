package com.hillel;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(3, "three");
        map.put(5, "five");

        for (int i = 1; i <= 5; i++) {
            map.computeIfPresent(i, (k, v) -> k + "----" + v);
            map.computeIfAbsent(i, (k) -> Integer.toString(k * k));
        }

        map.remove(1);
        map.remove(2, "222");

        System.out.println(map.getOrDefault(5, "five default"));
        System.out.println(map.getOrDefault(6, "six default"));

        for (Integer key : map.keySet()) {
            map.merge(key, "+(new value)", (oldVal, newVal) -> map.get(key) + newVal);
        }

        System.out.println("\n\nRESULT:");
        map.entrySet().forEach(System.out::println);
    }
}

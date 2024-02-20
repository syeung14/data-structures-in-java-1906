package eu.javaspecialists.courses.datastructures.ch6_maps;

import java.util.*;

/**
 * LinkedHashMap and LinkedHashSet
 */
public class _6_7_LinkedHashMapAndSet {
    public static void main(String... args) {
        Set<Integer> numbers = new LinkedHashSet<>();
        Collections.addAll(numbers, 300, 100, 400, 100, 500, 900);
        System.out.println("numbers = " + numbers);
    }
}

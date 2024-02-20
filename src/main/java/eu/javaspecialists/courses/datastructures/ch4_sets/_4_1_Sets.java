package eu.javaspecialists.courses.datastructures.ch4_sets;

import java.util.*;

/**
 * Set.of()
 * union with addAll()
 * intersection with retainAll() or stream/filter
 */
public class _4_1_Sets {
    public static void main(String... args) {
        Set<Integer> integers = Set.of(100, 200, 300, 400, 500, 600, 700, 800);
        System.out.println("integers = " + integers);

    }
}

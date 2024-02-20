package eu.javaspecialists.courses.datastructures.ch4_sets;

import java.util.*;

/**
 * Sorted by natural order
 * Red-black tree
 * Unbalanced tree O(n) vs O(log n)
 * Counting maximum tree depth
 */
public class _4_2_TreeSet {
    public static void main(String... args) {
        Set<Integer> integers = new TreeSet<>(
                Set.of(100, 200, 300, 400, 500, 600, 700, 800));
        System.out.println("integers = " + integers);

        for (int i = 0; i < 1_000_000; i++) {
            integers.add(i);
        }
        // worst case - 2 * log2(n) - worst case 40
    }
}

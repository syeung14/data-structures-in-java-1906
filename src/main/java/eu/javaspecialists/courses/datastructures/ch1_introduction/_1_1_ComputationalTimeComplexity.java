package eu.javaspecialists.courses.datastructures.ch1_introduction;

import java.util.*;

/**
 * Computational Time and Space Complexity
 * O(1), O(n), O(n^2^), O(log n), O(n * log n)
 */
public class _1_1_ComputationalTimeComplexity {
    public static void main(String... args) {
        // add to end of ArrayList - O(1)
        // remove from front of ArrayList O(n)
        // search a binary tree - O(log n)
        // sort a list - O(n * log n) - quasilinear
        // bubble sort - O(n^2)
        // lookup O(n) is a problem

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 160_000; i++) {
            list.add(i);
        }

        long time = System.nanoTime();
        try {
            list.containsAll(list);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}

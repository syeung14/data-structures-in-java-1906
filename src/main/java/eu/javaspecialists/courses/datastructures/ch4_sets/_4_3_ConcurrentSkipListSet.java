package eu.javaspecialists.courses.datastructures.ch4_sets;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/**
 * Thread-safe sorted set
 */
public class _4_3_ConcurrentSkipListSet {
    public static void main(String... args) {
        // log n
        Set<Integer> set = new ConcurrentSkipListSet<>();
        IntStream.range(0, 10_000_000)
                .parallel()
                .forEach(set::add);
        System.out.println("set.size() = " + set.size());
    }
}

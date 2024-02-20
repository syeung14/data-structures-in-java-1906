package eu.javaspecialists.courses.datastructures.ch5_hashing;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/**
 * ConcurrentHashMap.newKeySet()
 */
public class _5_3_ConcurrentHashMapNewKeySet {
    public static void main(String... args) {
        Set<Integer> numbers = ConcurrentHashMap.newKeySet();
        // Set<Integer> numbers = Collections.newSetFromMap(new ConcurrentHashMap<>());
        // Set<Integer> numbers = new HashSet<>();
        IntStream.range(0, 100_000)
                .parallel()
                .forEach(numbers::add);
        System.out.println(numbers.size());
        int count = 0;
        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()) {
            it.next();
            count++;
        }
        System.out.println("count = " + count);
    }
}

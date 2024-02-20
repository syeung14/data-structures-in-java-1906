package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.*;
import java.util.stream.*;

/**
 * Adding four seasons
 * indexOf() and contains()
 * size() vs elementData.length in debugger
 * removeIf()
 */
public class _2_2_ArrayList {
    public static void main(String... args) {

        int[] primitives = {1, 2, 3, 4, 5};
        Integer[] boxed = IntStream.of(primitives).boxed().toArray(Integer[]::new);

        ArrayList<Integer> numbers = IntStream.range(0, 10_000).boxed()
                .collect(Collectors.toCollection(() -> new ArrayList<>(10_000)));
        numbers.trimToSize(); // makes it size 10_000
        System.out.println("numbers.size() = " + numbers.size());
        int arrayLength = 10;
        while(arrayLength <= 10_000) arrayLength *= 1.5;
        System.out.println("arrayLength = " + arrayLength);

        numbers.clear();
        var numbers2 = new ArrayList<>(numbers);
        for (int i = 0; i < 10_000_000; i++) {
            numbers2.add(i);
        }
        // O(n) with LinkedList, O(n) with ArrayList
        numbers2.removeIf(next -> next % 2 == 1);

        // O(n) with LinkedList, O(n^2) with ArrayList
        // for (Iterator<Integer> it = numbers2.iterator(); it.hasNext(); ) {
        //     Integer next = it.next();
        //     if (next % 2 == 1) it.remove();
        // }
        System.out.println(numbers2.size());

        long time = System.nanoTime();
        try {
            new HashSet<>(numbers2).containsAll(numbers2);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
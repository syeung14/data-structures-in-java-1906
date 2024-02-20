package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.*;

/**
 * Arrays.asList()
 * Quick look at the List methods
 * Optional methods
 * asList() vs List.of()
 * RandomAccess
 */
public class _2_1_Lists {
    public static void main(String... args) {
        // List<Integer> list = Arrays.asList(1, 2, 3); // do not use
        List<Integer> list = List.of(1, 2, 3); // use instead
        // list.set(0, 4);
        System.out.println("list = " + list);
    }

}

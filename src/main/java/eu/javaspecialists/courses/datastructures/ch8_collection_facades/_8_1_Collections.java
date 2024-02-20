package eu.javaspecialists.courses.datastructures.ch8_collection_facades;

import java.util.*;

/**
 * java.util.Collections
 */
public class _8_1_Collections {
    public static void main(String... args) {
        List<String> names = Collections.checkedList(new ArrayList<>(), String.class);
        List numbers = names;
        numbers.add(3);

        System.out.println("numbers = " + numbers);
        System.out.println("names = " + names);
        for (String name : names) {
            System.out.println("name = " + name);
        }
        // Collections.checkedCollection()
    }
}

package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.*;
import java.util.concurrent.*;

/**
 * Safe iteration
 */
public class _2_4_CopyOnWriteArrayList {
    public static void main(String... args) {
        List<Integer> cowList = new CopyOnWriteArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            tempList.add(i);
        }
        cowList.addAll(tempList);
        System.out.println("cowList.size() = " + cowList.size());
    }
}

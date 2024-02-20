package eu.javaspecialists.courses.datastructures.ch1_introduction;

import eu.javaspecialists.courses.datastructures.ch2_lists.RaceConditionDangerDetectingList;

import java.util.*;

public class WhatIsThreadSafety {
    public static void main(String... args) throws InterruptedException {
        long time = System.nanoTime();
        try {
            // List<Integer> list = Collections.synchronizedList(new LinkedList<>());
            // List<Integer> list = Collections.synchronizedList(new ArrayList<>());
            // List<Integer> list = new RaceConditionDangerDetectingList<>();
            List<Integer> list = new Vector<>();
            // List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            List<Thread> threads = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                threads.add(Thread.ofPlatform().start(() -> {
                    for (int i = 0; i < 100_000; i++) {
                        list.add(i);
                        list.removeFirst();
                    }
                }));
            }
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println(list.size());
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}

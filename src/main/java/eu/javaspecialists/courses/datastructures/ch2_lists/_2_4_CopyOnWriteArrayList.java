package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Safe iteration
 */
public class _2_4_CopyOnWriteArrayList {
    public static void main(String... args) throws InterruptedException {

        List<Integer> list = new Vector<>();
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

        for (Thread t : threads) {
            t.join();
        }
        System.out.println(list.size());
        System.out.println(list);

    }
}

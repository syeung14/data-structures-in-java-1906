package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.*;
import java.util.concurrent.*;

/**
 * Enumeration bugs
 * Fail fast collection
 * forEach()
 */
public class _2_3_Iteration {
    public static void main(String... args) {
        Collection<String> beachToys = new ConcurrentLinkedQueue<>(); // weakly-consistent
        // Collection<String> beachToys = new CopyOnWriteArrayList<>(); // snapshot
        // Collection<String> beachToys = new ArrayList<>(); // fast-fail
        Collections.addAll(beachToys, "floatie", "sunblock", "rage", "razor",
                "umbrella", "bucket", "raki");
        for (Iterator<String> iterator = beachToys.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if (next.startsWith("ra")) beachToys.remove(next);
        }
        System.out.println("beachToys = " + beachToys);
    }
}

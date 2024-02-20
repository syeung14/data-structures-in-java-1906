package eu.javaspecialists.courses.datastructures.ch5_hashing;

import java.util.*;

/**
 * Writing very basic hashtable
 * Clashes and distribution
 * % vs &
 *
 * SUmmary:
 * we showed how to write a very basic hash map
 *     - not safe - can get O(n) performance
 *
 * Always implement Comparable on your keys
 *  (Or use something like a String for a key)
 *
 * Make the hashCode as perfect as possible
 *
 * hashCode value should be as small as possible
 *
 * Use records for keys.
 */
public class _5_1_Hashing {
    public static void main(String... args) {
        Pixel[] pixels = new Pixel[1920 * 1080];
        for (int x = 0; x < 1920; x++) {
            for (int y = 0; y < 1080; y++) {
                pixels[x * 1080 + y] = new Pixel(x, y);
            }
        }

        Set<Integer> hashCodes = new HashSet<>();
        for (Pixel pixel : pixels) {
            hashCodes.add(pixel.hashCode());
        }
        System.out.println("hashCodes.size() = " + hashCodes.size());

        for (int i = 0; i < 100; i++) {
            testHashing(pixels);
        }
    }

    private static void testHashing(Pixel[] pixels) {
        HashMap<Pixel, Boolean> pixelMap = HashMap.newHashMap(1920 * 1080);
        long time = System.nanoTime();
        try {
            for (Pixel pixel : pixels) {
                pixelMap.put(pixel, true);
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}

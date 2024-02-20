package eu.javaspecialists.courses.datastructures.ch0_welcome.demo;

import eu.javaspecialists.courses.datastructures.ch5_hashing.Pixel;

import java.util.*;

public class SimpleBadHashMap<K, V> {
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int capacity = 1_000_001;

    public SimpleBadHashMap() {
        table = new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        return entry.value;
    }

    public static void main(String[] args) {
        SimpleBadHashMap<String, Integer> map = new SimpleBadHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("One: " + map.get("One"));
        System.out.println("Two: " + map.get("Two"));
        System.out.println("Three: " + map.get("Three"));

        // Demonstrating the generic capability
        SimpleBadHashMap<Integer, String> reverseMap = new SimpleBadHashMap<>();
        reverseMap.put(1, "One");
        reverseMap.put(2, "Two");
        reverseMap.put(3, "Three");

        System.out.println("1: " + reverseMap.get(1));
        System.out.println("2: " + reverseMap.get(2));
        System.out.println("3: " + reverseMap.get(3));

        var badMap = new SimpleBadHashMap<List<Integer>, String>();
        badMap.put(List.of(0, 31), "0,31");
        System.out.println(badMap.get(List.of(0, 31)));
        System.out.println(badMap.get(List.of(1, 0)));
    }

    private static void testPixelHashing(Pixel[] pixels) {
        SimpleBadHashMap<Pixel, Boolean> pixelMap = new SimpleBadHashMap<>();
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



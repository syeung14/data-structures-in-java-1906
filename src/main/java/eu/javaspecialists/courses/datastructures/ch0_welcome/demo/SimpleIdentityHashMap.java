package eu.javaspecialists.courses.datastructures.ch0_welcome.demo;

import eu.javaspecialists.courses.datastructures.ch5_hashing.Pixel;

public class SimpleIdentityHashMap<K, V> {
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

    public SimpleIdentityHashMap() {
        table = new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(System.identityHashCode(key) % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.getKey() == key) {
                    current.setValue(value);
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null; // Indicates not found
    }

    public static void main(String[] args) {
        SimpleIdentityHashMap<String, Integer> map = new SimpleIdentityHashMap<>();
        map.put(new String("One"), 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("One: " + map.get("One"));
        System.out.println("Two: " + map.get("Two"));
        System.out.println("Three: " + map.get("Three"));

        // Demonstrating the generic capability
        SimpleIdentityHashMap<Integer, String> reverseMap = new SimpleIdentityHashMap<>();
        reverseMap.put(1, "One");
        reverseMap.put(2, "Two");
        reverseMap.put(3, "Three");

        System.out.println("1: " + reverseMap.get(1));
        System.out.println("2: " + reverseMap.get(2));
        System.out.println("3: " + reverseMap.get(3));

    }
}



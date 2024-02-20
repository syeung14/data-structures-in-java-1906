package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Sorting performance ArrayList vs LinkedList
 * Parallel sorting of ArrayList
 * -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xmx20g -Xms20g -XX:+AlwaysPreTouch -verbose:gc
 */
public class _3_4_ParallelSorting {
    public static void main(String... args) {
        List<Integer> baseList = ThreadLocalRandom.current().ints(10_000_000)
                .boxed().collect(Collectors.toList());

        for (int i = 0; i < 5; i++) {
            testSorting(baseList, list -> list.sort(null));
            testSorting(baseList, list -> parallelSort(list, null));
            System.out.println();
        }
    }

    private static<E> void parallelSort(List<E> list, Comparator<E> comparator) {
        Object[] a = list.toArray();
        Arrays.parallelSort(a, (Comparator) comparator);
        ListIterator<E> i = list.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }

    private static void testSorting(List<Integer> baseList,
                                    Consumer<List<Integer>> sorter) {
        List<Integer> arrayList = new ArrayList<>(baseList);
        List<Integer> linkedList = new LinkedList<>(baseList);

        long arraySortTime = System.nanoTime();
        try {
            sorter.accept(arrayList);
        } finally {
            arraySortTime = System.nanoTime() - arraySortTime;
            System.out.printf("arraySortTime = %dms%n", (arraySortTime / 1_000_000));
        }

        long linkedSortTime = System.nanoTime();
        try {
            sorter.accept(linkedList);
        } finally {
            linkedSortTime = System.nanoTime() - linkedSortTime;
            System.out.printf("linkedSortTime = %dms%n", (linkedSortTime / 1_000_000));
        }
    }
}

package eu.javaspecialists.courses.datastructures.ch0_welcome;

import java.util.*;
import java.util.concurrent.*;

public class _0_2_Interfaces {
    public static void main(String... args) {
        Iterable<?> iterable;
        Collection<?> collection; // extends Iterable
        SequencedCollection<?> seqCol; // Java 21, extends Collection

        List<?> list; // extends SequencedCollection

        Set<?> set; // extends Collection
        SequencedSet<?> seqset; // extends SequencedCollection, Set
        SortedSet<?> sortedSet; // extends SequencedSet, Set
        NavigableSet<?> navigableSet; // extends SortedSet

        Queue<?> queue; // extends Collection
        BlockingQueue<?> blockingQueue; // extends Queue
        TransferQueue<?> transferQueue; // extends BlockingQueue
        Deque<?> deque; // extends Queue, SequencedCollection
        BlockingDeque<?> blockingDeque; // extends BlockingQueue and Deque


        Map<?, ?> map;
        SequencedMap<?, ?> seqMap; // Java 21, extends Map

        SortedMap<?, ?> sortedMap; // extends SequencedMap
        NavigableMap<?, ?> navigableMap; // extends SortedMap

        ConcurrentMap<?, ?> concurrentMap; // extends Map
        ConcurrentNavigableMap<?, ?> concurrentNavigableMap; // extends ConcurrentMap and NavigableMap
    }
}

package eu.javaspecialists.courses.datastructures.ch0_welcome;

import java.util.*;
import java.util.concurrent.*;

public class _0_4_ImplementationClasses {
    public static void main(String... args) {
        List<?>[] lists = {
                new ArrayList<>(), // array based list, not thread-safe
                new CopyOnWriteArrayList<>(), // array based list, thread-safe - synchronized
                new LinkedList<>(), // linked node based list, not thread-safe. Is also a Deque.
                new Stack<>(), // Use either ArrayDeque or ConcurrentLinkedDeque
                new Vector<>(), // array based list, thread-safe - synchronized
                List.of(1, 2, 3), // immutable list
                Collections.synchronizedList(new ArrayList<>())
        };

        Set<?>[] sets = {
                new CopyOnWriteArraySet<>(), // array-based set, thread-safe, but expensive
                new HashSet<>(), // array-based, plus linked list and red-black tree for clashes, not thread-safe
                new LinkedHashSet<>(), // like HashSet, but also retains order of insertions
                EnumSet.of(Thread.State.RUNNABLE, Thread.State.NEW), // simple bit-set
                Set.of(1, 2, 3), // immutable set
        };
        NavigableSet<?>[] navigableSets = {
                new TreeSet<>(), // red-black tree based set, not thread-safe
                new ConcurrentSkipListSet<>() // skip-list based set, sorted, thread-safe
        };

        Queue<?>[] queues = {
                new ConcurrentLinkedQueue<>(), // thread-safe - CAS - VarHandle
        };
        BlockingQueue<?>[] blockingQueues = {
                new ArrayBlockingQueue<>(10), // fixed-length circular array queue - ReentrantLock
                new DelayQueue<>(), // scheduled thread pool
                new LinkedBlockingQueue<>(), // fixed thread pool - ReentrantLock
                new PriorityBlockingQueue<>(), // not used
                new SynchronousQueue<>(), // cached thread pool
        };
        TransferQueue<?>[] transferQueues = {
                new LinkedTransferQueue<>(), // linked-node based queue, never used in the JDK
        };
        Deque<?>[] deques = {
                new ArrayDeque<>(), // array based, grows, not thread-safe
                new ConcurrentLinkedDeque<>(), // linked node structure, thread-safe
        };
        BlockingDeque<?>[] blockingDeques = {
                new LinkedBlockingDeque<>(),
        };


        Map<?, ?>[] maps = {
                new EnumMap<>(Thread.State.class),
                new HashMap<>(), // not thread-safe
                new Hashtable<>(), // thread-safe, legacy
                new IdentityHashMap<>(),
                new LinkedHashMap<>(),
                new Properties(),
                new WeakHashMap<>(),
                Map.of(1, "one", 2, "two", 3, "three"), // immutable map
        };
        NavigableMap<?, ?>[] navigableMaps = {
                new TreeMap<>(),// red-black tree based map, not thread-safe
                new ConcurrentSkipListMap<>(), // skip-list based set, thread-safe
        };
        ConcurrentMap<?, ?>[] concurrentMaps = {
                new ConcurrentHashMap<>(), // thread-safe - synchronized
        };
        ConcurrentNavigableMap<?, ?>[] concurrentNavigableMaps = {
                new ConcurrentSkipListMap<>(), // thread-safe, sorted
        };
    }
}

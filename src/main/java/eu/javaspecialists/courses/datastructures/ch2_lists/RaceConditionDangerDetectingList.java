package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;

public class RaceConditionDangerDetectingList<E> implements List<E> {
    private final Set<Thread> threads = ConcurrentHashMap.newKeySet();
    private final List<E> list = new ArrayList<>();

    private void checkForMultipleThreads() {
        if (threads.add(Thread.currentThread())) {
            if (threads.size() > 1)
                throw new IllegalStateException("Multiple threads used this collection: " +
                        threads);
        }
    }

    private List<E> listWithCheck() {
        checkForMultipleThreads();
        return list;
    }

    @Override
    public int size() {
        return listWithCheck().size();
    }

    @Override
    public boolean isEmpty() {
        return listWithCheck().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return listWithCheck().contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return listWithCheck().iterator();
    }

    @Override
    public Object[] toArray() {
        return listWithCheck().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return listWithCheck().toArray(a);
    }

    @Override
    public boolean add(E e) {
        return listWithCheck().add(e);
    }

    @Override
    public boolean remove(Object o) {
        return listWithCheck().remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return listWithCheck().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return listWithCheck().addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return listWithCheck().addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return listWithCheck().removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return listWithCheck().retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        listWithCheck().replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        listWithCheck().sort(c);
    }

    @Override
    public void clear() {
        listWithCheck().clear();
    }

    @Override
    public boolean equals(Object o) {
        return listWithCheck().equals(o);
    }

    @Override
    public int hashCode() {
        return listWithCheck().hashCode();
    }

    @Override
    public E get(int index) {
        return listWithCheck().get(index);
    }

    @Override
    public E set(int index, E element) {
        return listWithCheck().set(index, element);
    }

    @Override
    public void add(int index, E element) {
        listWithCheck().add(index, element);
    }

    @Override
    public E remove(int index) {
        return listWithCheck().remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return listWithCheck().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return listWithCheck().lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return listWithCheck().listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return listWithCheck().listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return listWithCheck().subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<E> spliterator() {
        return listWithCheck().spliterator();
    }

    @Override
    public void addFirst(E e) {
        listWithCheck().addFirst(e);
    }

    @Override
    public void addLast(E e) {
        listWithCheck().addLast(e);
    }

    @Override
    public E getFirst() {
        return listWithCheck().getFirst();
    }

    @Override
    public E getLast() {
        return listWithCheck().getLast();
    }

    @Override
    public E removeFirst() {
        return listWithCheck().removeFirst();
    }

    @Override
    public E removeLast() {
        return listWithCheck().removeLast();
    }

    @Override
    public List<E> reversed() {
        return listWithCheck().reversed();
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return listWithCheck().toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return listWithCheck().removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return listWithCheck().stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return listWithCheck().parallelStream();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        listWithCheck().forEach(action);
    }
}
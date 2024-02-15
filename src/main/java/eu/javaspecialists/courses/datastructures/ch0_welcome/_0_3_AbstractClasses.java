package eu.javaspecialists.courses.datastructures.ch0_welcome;

import java.util.*;

public class _0_3_AbstractClasses {
    public static void main(String... args) {
        AbstractCollection<?> ac; // implement Collection

        AbstractList<?> al; // extends AbstractCollection implements List
        AbstractSequentialList<?> asl; // extends AbstractList, e.g. LinkedList

        AbstractSet<?> as; // extends AbstractCollection implements Set

        AbstractQueue<?> aq; // extends AbstractCollection implements Queue

        AbstractMap<?, ?> am; // implements Map
    }
}

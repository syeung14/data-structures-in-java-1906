package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.*;

/**
 * Sorting list of Strings
 * Sorting custom classes like Student
 * Comparing ints and longs
 */
public class _3_1_SortingLists {
    record Student(String initials, int iq) implements Comparable<Student>{
        @Override
        public int compareTo(Student o) {
            return initials.compareTo(o.initials);
        }
    }

    public static void main(String... args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3, 1, 4, 1, 5, 9);
        Collections.sort(list);
        System.out.println("sorted list = " + list);
        Collections.shuffle(list);
        System.out.println("shuffled list = " + list);
        List<Integer> reversed = list.reversed();
        System.out.println("reversed list = " + reversed);

        list.removeIf(i -> i == 1);
        System.out.println("list = " + list);
        System.out.println("reversed = " + reversed);

        List<Student> students = new ArrayList<>();
        students.add(new Student("JG", 120));
        students.add(new Student("AA", 110));
        students.add(new Student("BA", 130));
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.initials.compareTo(o2.initials);
                if (result != 0) return result;
                return Integer.compare(o1.iq, o2.iq);
            }
        });
        students.sort(Comparator.comparing(Student::initials)
                .thenComparingInt(Student::iq));
        System.out.println("sorted students = " + students);
    }
}

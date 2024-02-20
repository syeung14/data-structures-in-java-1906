package eu.javaspecialists.courses.datastructures.ch0_welcome.demo;

public class SimpleLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node<T> head; // Head of the list

    // Method to append a new node at the end
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    // Method to remove a node by value
    public void remove(T data) {
        if (head == null) return; // Empty list

        if (head.data.equals(data)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node<T> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }

        if (current == null) return; // Item not found

        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    // Method to print the list from head to tail
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> intList = new SimpleLinkedList<>();
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.printList(); // Expected: 1 <-> 2 <-> 3 <-> NULL

        SimpleLinkedList<String> stringList = new SimpleLinkedList<>();
        stringList.append("Hello");
        stringList.append("World");
        stringList.printList(); // Expected: Hello <-> World <-> NULL

        intList.remove(2);
        intList.printList(); // Expected: 1 <-> 3 <-> NULL
    }
}

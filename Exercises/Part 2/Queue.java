import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Queue<E> implements MyCollection<E>, Iterable<E> {

    /**
     * Private node class, used as nodes in the queue
     */
    private static class Node<T> {

        // Class Attributes
        private T value;
        private Node<T> next;

        // Constructor
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        private boolean contains(T t) {
            return ((this.value == t) || ((this.next != null) && this.next.contains(t)));
        }

        private int size() {
            if (this.next == null) {
                return 1;
            } else {
                return 1 + this.next.size();
            }
        }

        public String toString() {
            if (next == null) {
                return value + "]";
            } else {
                return value + ", " + next.toString();
            }
        }

        private boolean equals(Node<T> other) {
            if ((other == null) || (this.value != other.value)) {
                return false;
            } else if (this.next == null) {
                return (other.next == null);
            } else {
                return ((other.next != null) && this.next.equals(other.next));
            }
        }

        public int hashCode() {
            return Objects.hash(value, next);
        }

    }

    /**
     * Private iterator class, used to iterate the queue
     */
    private class QueueIterator implements Iterator<E> {
        private Node<E> current;

        private QueueIterator() {
            current = first;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public E next() throws NoSuchElementException {
            if (current == null) {
                throw new NoSuchElementException("No elements left in queue");
            }
            E next = current.value;
            current = current.next;
            return next;
        }

    }

    /**
     * Actual Queue now
     */

    // CLass Attributes
    private Node<E> first, last;

    // Constructor
    public Queue() {
        this.first = null;
        this.last = null;
    }

    /**
     * MyCollection implementation
     */

    public void add(E e) {
        Node<E> newNode = new Node<E>(e, null);
        if (this.first == null) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
    }

    public void clear() {
        this.first = null;
        this.last = null;
    }

    public boolean contains(E e) {
        return ((this.first != null) && this.first.contains(e));
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public int size() {
        if (this.first == null) {
            return 0;
        } else {
            return this.first.size();
        }
    }

    /**
     * Iterator implementation
     */

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    public E next() {
        E next = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return next;
    }

    /**
     * Additional methods
     */
    public String toString() {
        if (first == null) {
            return "[]";
        } else {
            return "[" + first.toString();
        }
    }

    public Queue<E> copy() {
        Queue<E> copy = new Queue<>();

        for (E e : this) {
            copy.add(e);
        }

        return copy;

    }

    public boolean equals(Object other) {
        if (!(other instanceof Queue)) {
            return false;
        }
        Queue<?> otherQueue = (Queue<?>) other;

        if (this.first == null) {
            return (otherQueue.first == null);
        } else {
            return this.first.equals(otherQueue.first);
        }
    }

    public int hashCode() {
        return Objects.hash(first);
    }

    /*
     * Basic testing.
     */
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(3);
        q.add(1);
        q.add(2);

        System.out.println("Next: " + q.next());
        System.out.println("Size: " + q.size());
        System.out.println("Contains 1: " + q.contains(1));
        System.out.println("Contains 2: " + q.contains(2));
        System.out.println("Contains 4: " + q.contains(4));
        System.out.println("Empty? " + q.isEmpty());
        q.clear();
        System.out.println("Size: " + q.size());
        System.out.println("Empty? " + q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q);
        for (Integer i : q)
            System.out.println("Iterating: " + i);
        q.next();
        q.next();
        System.out.println("Next: " + q.next());
        System.out.println("Size: " + q.size());
        System.out.println("Next: " + q.next());
        System.out.println("Size: " + q.size());

    }

}
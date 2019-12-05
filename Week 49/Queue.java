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

        private void add(T t){

            if (this.next == null){
                Node<T> newNode = new Node<>(t, null);
                this.next = newNode;
            } else {
                this.next.add(t);
            }

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
    private Node<E> first;

    // Constructor
    public Queue() {
        this.first = null;
    }

    /**
     * MyCollection implementation
     */

    public void add(E e) {
        if (this.first == null) {
            Node<E> newNode = new Node<E>(e, null);
            this.first = newNode;
        } else {
            this.first.add(e);   
        }
    }

    /**
     * Clear the queue
     */
    public void clear() {
        this.first = null;
    }

    /**
     * Check if the queue contains e
     */
    public boolean contains(E e) {
        return ((this.first != null) && this.first.contains(e));
    }

    /**
     * Checks if the queue is empty
     */
    public boolean isEmpty() {
        return (this.first == null);
    }

    /**
     * Returns the size of the queue
     */
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

    /*
     * Basic testing.
     */
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(3);
        q.add(1);
        q.add(2);

        // System.out.println("Next: " + q.next());
        // System.out.println("Size: " + q.size());
        // System.out.println("Contains 1: " + q.contains(1));
        // System.out.println("Contains 2: " + q.contains(2));
        // System.out.println("Contains 4: " + q.contains(4));
        // System.out.println("Empty? " + q.isEmpty());
        // q.clear();
        // System.out.println("Size: " + q.size());
        // System.out.println("Empty? " + q.isEmpty());
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // System.out.println(q);
        // for (Integer i : q)
        //     System.out.println("Iterating: " + i);
        // q.next();
        // q.next();
        // System.out.println("Next: " + q.next());
        // System.out.println("Size: " + q.size());
        // System.out.println("Next: " + q.next());
        // System.out.println("Size: " + q.size());

    }

}
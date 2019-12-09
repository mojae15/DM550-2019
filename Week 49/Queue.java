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

        public boolean equals(Node<?> n){
            return (n != null && this.value == n.value);
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

    public int hashcode(){
        return Objects.hash(first);
    }


    public boolean equals(Object other){

        if (!(other instanceof Queue)){
            return false;
        }

        Queue<?> otherQueue = (Queue<?>) other;

        if (this.first == null){
            return (otherQueue.first == null);
        }

        Node<E> t1 = this.first;
        Node<?> t2 = otherQueue.first;

        boolean equal = true;
        // Queue<E> thisCopy = this.copy();
        // Queue<?> otherCopy = otherQueue.copy();

        while (equal){
            equal = t1.equals(t2);
            t1 = t1.next;
            t2 = t2.next;
            if (t1 == null){
                return (t2 == null);
            }

            // if (thisCopy.first.next == null && otherCopy.first.next == null){
            //     return thisCopy.first.equals(otherCopy.first);
            // }
            // if (thisCopy.first.equals(otherCopy.first)){
            //     thisCopy.first = thisCopy.first.next;
            //     otherCopy.first = otherCopy.first.next;
            // } else {
            //     return false;
            // }
        }

        return equal;



    }

    public Queue<E> copy(){

        Queue<E> cpy = new Queue<>();

        for (E e : this){
            cpy.add(e);
        }

        return cpy;

    }

    public String toString(){

        String res = "";

        for (E e : this){
            res = res + e + " ";
        }


        return res;
    }

    /*
     * Basic testing.
     */
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(3);
        q.add(1);
        q.add(2);


        Queue<Integer> p = q.copy();

        for (Integer i : p){
            System.out.println("Iterating: " + i);
        }

        System.out.println(q.equals(p));

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

        // q.next();
        // q.next();
        // System.out.println("Next: " + q.next());
        // System.out.println("Size: " + q.size());
        // System.out.println("Next: " + q.next());
        // System.out.println("Size: " + q.size());

    }

}

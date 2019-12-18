import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Map<K, E> implements Iterable<E> {

    /**
     * Private inner node class
     */
    private static class Node<Key, Val> {

        // Class Attributes
        private Key k;
        private Val v;
        private Node<Key, Val> next;

        // Constructor
        private Node(Key k, Val v, Node<Key, Val> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        // Recursively add new key-val pair to map
        private void add(Key key, Val val) {
            if (this.k == key) {
                // If the key aldready exists, overwrite the value
                this.v = val;
            } else if (this.next == null) {
                // If we are at the last node, create a new one for the new key-val pair
                this.next = new Node<Key, Val>(key, val, null);
            } else {
                // Recursively add to the end of the list of nodes
                this.next.add(key, val);
            }
        }

        // Recursively search map for a specific key
        private Val find(Key key) {
            if (this.k == key) {
                return this.v;
            } else if (this.next == null) {
                return null;
            } else {
                return this.next.find(key);
            }
        }

        // Recursively remove a specific key
        private void remove(Key key) {
            if (this.next != null) {
                if (this.next.k.equals(key)) {
                    this.next = this.next.next;
                } else {
                    this.next.remove(key);
                }
            }
        }

        // Recursively calculate the size of the map
        private int size() {
            return ((this.next == null) ? 1 : 1 + this.next.size());
        }

        private <F, N> boolean contains(F key, N val){
            if (this.k.equals(key) && this.v.equals(val)){
                return true;
            } else if (this.next == null){
                return false;
            } else {
                return this.next.contains(key, val);
            }



        }

    }

    /**
     * Normal value iterator class
     */
    private class ValueIterator implements Iterator<E> {

        // Class Attributes
        private Node<K, E> current;

        // Constructor
        public ValueIterator() {
            this.current = head;
        }

        public boolean hasNext() {
            return (!(this.current != null));
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            } else {
                E val = current.v;
                current = current.next;
                return val;
            }

        }

    }

    /**
     * Key Iterator
     */
    private class KeyIterator implements Iterator<K> {

        // Class Attributes
        private Node<K, E> current;

        // Constructor
        public KeyIterator() {
            this.current = head;
        }

        public boolean hasNext() {
            return (!(this.current != null));
        }

        public K next() {
            if (!(hasNext())) {
                throw new NoSuchElementException("No more elements");
            } else {
                K key = current.k;
                current = current.next;
                return key;
            }
        }

    }

    /**
     * Map class
     */

    // Class Attributes
    private Node<K, E> head;

    // Constructor
    public Map() {
        this.head = null;
    }

    // Add new key-val pair to the map
    public void add(K key, E e) {

        if (head == null) {
            head = new Node<K, E>(key, e, null);
        } else {
            head.add(key, e);
        }

    }

    // Clear map
    public void clear() {
        this.head = null;
    }

    // Search map for the value of key
    public E find(K key) {
        return this.head.find(key);
    }

    // Check if the map is empty
    public boolean isEmpty() {
        return (this.head == null);
    }

    // Remove node containing the key we are looking for
    public void remove(K key) {
        if (head != null) {
            if (head.k.equals(key)) {
                head = head.next;
            } else {
                head.remove(key);
            }
        }
    }

    // Return size of the map
    public int size() {
        return ((head == null) ? 0 : head.size());
    }

    // Return a list of keys
    public K[] keys() {
        K[] keys = (K[]) new Object[size()];
        Node<K, E> current = this.head;
        int i = 0;
        while (current != null) {
            keys[i] = current.k;
            i++;
            current = current.next;
        }
        return keys;
    }

    // Return list of values in map
    public E[] values() {
        E[] vals = (E[]) new Object[size()];
        Node<K, E> current = this.head;
        int i = 0;
        while (current != null) {
            vals[i] = current.v;
            i++;
            current = current.next;
        }
        return vals;
    }

    // Iterator from implementing Iterable<E>
    public Iterator<E> iterator() {
        return new ValueIterator();
    }

    // Key Iterator
    public Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    public boolean equals(Object other){

        if (!(other instanceof Map)){
            return false;
        }

        Map<?,?> otherMap = (Map<?,?>) other;
        //If this is empty, the other map must also be empty
        if (this.head == null){
            return otherMap.head == null;
        } else if (this.size() != otherMap.size()){
            //If they are not the same size they cannot be equal to eachother
            return false;
        } else {

            //Check if each node of this map is in the other map
            boolean contained = true;
            Node<K, E> current = this.head;
            while (current != null && contained){

                contained = otherMap.contains(current.k, current.v);
                current = current.next;

            }
            return contained;
        }

    }

    private <F, N> boolean contains(F key, N val){

        if (this.head == null){
            return false;
        } else {
            return this.head.contains(key, val);
        }

    }

    // Cannot guarantee that the hashcode is the same for two equal objects, since they are not sorted
    public int hashCode(){
        return Objects.hash(this.head);
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new Map<Integer, String>();
        map.add(1, "Hej");
        map.add(2, "Med");

        Map<Integer, String> map2 = new Map<Integer, String>();
        map2.add(1, "Hej");
        map2.add(2, "Med");

        System.out.println(map.equals(map2));

    }

}
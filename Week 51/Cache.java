import java.util.Iterator;

public class Cache<K, E> /*implements Iterable<E>*/ {

    /**
     * Inner class defining key-value pair, with a counter
     */
    private static class Pair<Key, Val> {

        // Class Atributes
        private Key k;
        private Val v;
        private int uses;
        private Pair<Key, Val> next;
        private Pair<Key, Val> prev;

        private Pair(Key k, Val v) {
            this.k = k;
            this.v = v;
            this.uses = 0;
            this.next = null;
            this.prev = null;
        }

    }

    /**
     * Inner value iterator class
     */
    private class ValueIterator implements Iterator<E> {

        private Pair<K, E> nextPair;

        private ValueIterator() {
            this.nextPair = first;
        }

        public boolean hasNext() {
            return (this.nextPair != null);
        }

        public E next() {
            E res = nextPair.v;

            nextPair = nextPair.next;
            return res;

        }

    }

    /**
     * Inner key iterator class
     */
    private class KeyIterator implements Iterator<K> {

        private Pair<K, E> nextPair;

        private KeyIterator() {
            this.nextPair = first;
        }

        public boolean hasNext() {
            return (this.nextPair != null);
        }

        public K next() {
            K res = nextPair.k;

            nextPair = nextPair.next;
            return res;

        }

    }

    /**
     * SimpleCache class
     */

    // Class Atributes
    private Pair<K, E> first;
    private Pair<K, E> last;
    private int capacity;

    // Constructor
    public Cache(int capacity) {
        this.first = null;
        this.last = null;
        this.capacity = capacity;
    }

    /**
     * Add a key-value pair to a map. Start by removing the key if it exists, so we can overwrite it
     */
    public void add(K key, E e) {

        if (this.first == null){
            this.first = new Pair<K, E>(key, e);
            this.last = this.first;
        } else {
            remove(key);
        
            if (size() == capacity){
                removeSmallest();
            }
            this.last.next = new Pair<K, E>(key, e);
            this.last.next.prev = this.last;
            this.last = this.last.next;
        }
    }

    /**
     * Remove the least accessed element from the cache
     */
    private void removeSmallest(){
        Pair<K, E> current = this.first;
        Pair<K, E> smallest = this.first;

        // Find pair with the least amount of uses
        while (current != null){
            if (current.uses < smallest.uses){
                smallest = current;
            }
            current = current.next;
        }

        // Remove the pair
        removePair(smallest);


    }

    private void removePair(Pair<K, E> p){
        if (p.prev == null){
            // We are trying to remove the first node
            this.first = p.next;
            if (this.first.prev != null){
                // The cache only contained one element
                this.first.prev = null;
            }

        } else {
            p.prev.next = p.next;
        }

        if (p.next == null){
            // We are trying to remove the last node
            this.last = p.prev;
            if (this.last.next != null){
                // The cache only contained one element
                this.last.next = null;
            }
        } else {
            p.next.prev = p.prev;
        }
    }

    /**
     * Clear cache
     */
    public void clear() {
        this.first = null;
    }

    /**
     * Searches the cache for a key, and returns the value it maps to If it doesn't
     * exist, return null
     */
    public E find(K key) {

        E res = null;
        boolean found = false;

        Pair<K, E> current = this.first;
        while (current != null && !found){
            if (current.k.equals(key)){
                res = current.v;
                current.uses = current.uses + 1;
                found = true;
            }
            current = current.next;
        }

        return res;

    }

    /**
     * Returns true if the cache is empty
     */
    public boolean isEmpty() {
        return (this.first == null);
    }

    /**
     * Remove a key-value pair from the cache
     */
    public void remove(K key) {

        Pair<K, E> current = this.first;
        boolean removed = false;

        while (current != null && !removed){
            if (current.k.equals(key)){
                removePair(current);
                removed = true;

            }

            current = current.next;
        }
        
    }

    /**
     * Returns the size of the cache
     */
    public int size() {
        
        int count = 0;

        Pair<K, E> current = this.first;

        while (current != null){
            current = current.next;
            count = count + 1;
        }
        return count;
        
        
    }

    /**
     * Returns an array containing all keys in the cache
     */
    public K[] keys() {
        K[] keys = (K[]) new Object[size()];

        int i = 0;
        Pair<K, E> current = this.first;

        while (current != null){
            keys[i] = current.k;
            i = i + 1;
            current = current.next;
        }

        return keys;
    }

    /**
     * Returns an array containing all values in the cache
     */
    public E[] values() {
        E[] values = (E[]) new Object[size()];

        int i = 0;
        Pair<K, E> current = this.first;

        while (current != null){
            values[i] = current.v;
            i = i + 1;
            current = current.next;

        }
        return values;
    }

    /**
     * Returns the iterator for the cache
     */
    public Iterator<E> iterator() {
        return new ValueIterator();
    }

    public Iterator<K> keyIterator(){
        return new KeyIterator();
    }

    public static void main(String[] args) {
        Cache<Integer, String> m = new Cache<Integer, String>(2);
        m.add(1, "Hello");
        m.add(2, "World");
        m.add(3, "Hey");

        System.out.println("Size: " + m.size());

        // KILL ME
        Object[] temp = m.values();
        for (Object o : temp) {
            System.out.println((String) o);
        }

        System.out.println("length: " + temp.length);

    }

}
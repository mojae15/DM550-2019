import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

// SimpleCache done using an ArrayList. Done using a inner Pair class to keep track of the key value pairs
public class SimpleCache1<K, E> implements Iterable<E> {

    /**
     * Inner class defining key-value pair
     */
    private static class Pair<Key, Val> {

        // Class Atributes
        private Key k;
        private Val v;

        private Pair(Key k, Val v) {
            this.k = k;
            this.v = v;
        }

    }

    /**
     * Inner value iterator class
     */
    private class ValueIterator implements Iterator<E> {

        private Iterator<Pair<K, E>> iterator;

        private ValueIterator() {
            this.iterator = cache.iterator();
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public E next() {
            return this.iterator.next().v;
        }

    }

    /**
     * Inner key iterator class
     */
    private class KeyIterator implements Iterator<K> {

        private Iterator<Pair<K, E>> iterator;

        private KeyIterator() {
            this.iterator = cache.iterator();
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public K next() {
            return this.iterator.next().k;
        }

    }

    /**
     * SimpleCache class
     */

    // Class Atributes
    private ArrayList<Pair<K, E>> cache;
    private int capacity;

    // Constructor
    public SimpleCache1(int capacity) {
        this.cache = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * Add a key-value pair to a map. Starts by removing the mapping if it exists,
     * so we can override the value if needed
     */
    public void add(K key, E e) {
        remove(key);

        // If we are at the limit of the capacity, remove the first element. This will
        // then shift the next element to be the first, which can then be removed next
        // time
        if (this.cache.size() == this.capacity) {
            this.cache.remove(0);
        }

        // Add the new key-value pair.
        this.cache.add(new Pair<K, E>(key, e));
    }

    /**
     * Clear cache
     */
    public void clear() {
        this.cache.clear();
    }

    /**
     * Searches the cache for a key, and returns the value it maps to If it doesn't
     * exist, return null
     */
    public E find(K key) {

        for (Pair<K, E> p : this.cache) {
            if (p.k.equals(key)) {
                return p.v;
            }
        }

        return null;

    }

    /**
     * Returns true if the cache is empty
     */
    public boolean isEmpty() {
        return this.cache.isEmpty();
    }

    /**
     * Remove a key-value pair from the cache, using the "remove" function from the
     * iterator
     */
    public void remove(K key) {
        Iterator<Pair<K, E>> iter = this.cache.iterator();
        while (iter.hasNext()) {
            if (iter.next().k.equals(key)) {
                iter.remove();
            }
        }
    }

    /**
     * Returns the size of the cache
     */
    public int size() {
        return this.cache.size();
    }

    /**
     * Returns an array containing all keys in the cache
     */
    public K[] keys() {
        K[] keys = (K[]) new Object[this.cache.size()];

        int i = 0;
        for (Pair<K, E> p : this.cache) {
            keys[i] = p.k;
            i++;
        }
        return keys;
    }

    /**
     * Returns an array containing all values in the cache
     */
    public E[] values() {
        E[] values = (E[]) new Object[this.cache.size()];

        int i = 0;
        for (Pair<K, E> p : this.cache) {
            values[i] = p.v;
            i++;
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
        SimpleCache1<Integer, String> m = new SimpleCache1<Integer, String>(2);
        m.add(1, "Hello");
        m.add(2, "World");
        m.add(1, "Hey");

        System.out.println("Size: " + m.size());

        // KILL ME
        Object[] temp = m.values();
        for (Object o : temp) {
            System.out.println((String) o);
        }

        System.out.println("Length: " + temp.length);

    }

}
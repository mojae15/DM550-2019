import java.util.Iterator;
import java.util.NoSuchElementException;

// SimpleCache done using an Array. Done using a inner Pair class to keep track of the key value pairs
public class SimpleCache2<K, E> implements Iterable<E> {

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

        private int count;

        private ValueIterator() {
            this.count = 0;
        }

        public boolean hasNext() {
            return (cache[count] != null);
        }

        public E next() {
            E next = cache[count].v;
            count = count + 1;
            return next;
            
        }

    }

    /**
     * Inner key iterator class
     */
    private class KeyIterator implements Iterator<K> {

        private int count;

        private KeyIterator() {
            this.count = 0;
        }

        public boolean hasNext() {
            return (cache[count] != null);
        }

        public K next() {
            K next = cache[count].k;
            count = count + 1;
            return next;
            
        }

    }

    /**
     * SimpleCache class
     */

    // Class Atributes
    private Pair<K, E>[] cache;
    private int capacity;
    private int loc;

    // Constructor
    public SimpleCache2(int capacity) {
        this.cache = (Pair<K, E>[]) new Pair[capacity];
        this.capacity = capacity;
        this.loc = 0;
    }

    /**
     * Add a key-value pair to a map. Starts by removing the mapping if it exists,
     * so we can override the value if needed
     */
    public void add(K key, E e) {
        remove(key);

        if (this.loc == this.capacity){
            this.loc = 0;
        }

        this.cache[this.loc] = new Pair<K, E>(key, e);

        this.loc = this.loc + 1;
    }

    /**
     * Clear cache
     */
    public void clear() {
        for (int i = 0; i < this.capacity; i++){
            this.cache[i] = null;
        }
        this.loc = 0;
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
        return (this.cache[0] == null);
    }

    /**
     * Remove a key-value pair from the cache, shifts everything to the left if something is removed
     */
    public void remove(K key) {

        boolean removed = false;

        int i = 0;

        System.out.println("trying to remove key; "+key);
        while (i < this.capacity){

            if (this.cache[i] != null && this.cache[i].k.equals(key)){
                
                removed = true;
            }
            if (removed){
                if (i == this.capacity-1){
                    this.cache[i] = null;
                } else {
                    this.cache[i] = this.cache[i+1];
                }
            }
            i = i+1;
        }
        this.loc = size();
    }

    /**
     * Returns the size of the cache
     */
    public int size() {
        int count = 0;
        int i = 0;
        boolean isNull = false;
        
        while (i < this.capacity && !isNull){

            if (this.cache[i] == null){
                isNull = true;   
            } else {
                count = count + 1;
            }
            i = i + 1;
        }

        return count;

    }

    /**
     * Returns an array containing all keys in the cache
     */
    public K[] keys() {
        K[] keys = (K[]) new Object[size()];

        int i = 0;
        while ( i < keys.length){
            keys[i] = this.cache[i].k;
            i = i + 1;

        }
        return keys;
    }

    /**
     * Returns an array containing all values in the cache
     */
    public E[] values() {
        E[] values = (E[]) new Object[size()];

        int i = 0;

        while ( i < values.length){
            values[i] = this.cache[i].v;
            i = i + 1;

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
        SimpleCache2<Integer, String> m = new SimpleCache2<>(2);
        m.add(1, "Hello");
        m.add(2, "World");
        m.add(3, "Hey");

        System.out.println("Size: " + m.size());

        // KILL ME
        Object[] temp = m.values();
        for (Object o : temp) {
            System.out.println((String) o);
        }

        System.out.println("Length: " + temp.length);

    }

}
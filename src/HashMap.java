import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class HashMap<K, V> implements Map<K, V> {

    private int size;
    private List<Entry<K, V>>[] elements;
    public static final int DEFAULT_CAPACITY = 11;
    public static final double LOAD_FACTOR = .75;

    @SuppressWarnings("unchecked")
    HashMap() {
        size = 0;
        elements = new List[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        ensureCapacity();
        if (contains(key)) {
            return;
        }

        int index = hash(key);
        if (elements[index] == null) {
            elements[index] = new LinkedList<>();
        }
        elements[index].add(new Entry<>(key, value));
        size++;
    }

    private void ensureCapacity() {
        if ((double) size / elements.length > LOAD_FACTOR){
            List<Entry<K, V>>[] newElements = new List[elements.length * 2];

        }
    }

    @Override
    public void remove(K key) {
        if (contains(key)) {
            int index = hash(key);
            for (Entry<K, V> e : elements[index]) {
                if (e.key.equals(key)) {
                    elements[index].remove(e);
                    size--;
                }
            }

        }
    }

    @Override
    public boolean contains(K key) {
        int index = hash(key);
        if (elements[index] == null) {
            return false;
        }

        for (Entry<K, V> e : elements[index]) {
            if (e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    private int hash(K key) {
        return key.hashCode() % elements.length;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(", ","[","]");
        for (List<Entry<K, V>> list : elements) {
            if (list != null) {
                for (Entry<K, V> j : list) {
                    sj.add(j.toString());
                }
            }

        }
        return sj.toString();
    }

    private static class Entry<K, V> {
        public K key;
        public V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }
}

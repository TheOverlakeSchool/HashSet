import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class HashSet<T> implements Set<T> {

    private int size;
    private List<T>[] elements;
    public static final int DEFAULT_CAPACITY = 11;
    public static final double LOAD_FACTOR = .75;

    @SuppressWarnings("unchecked")
    HashSet() {
        size = 0;
        elements = new List[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T value) {
        ensureCapacity();
        if (contains(value)) {
            return;
        }

        int index = hash(value);
        if (elements[index] == null) {
            elements[index] = new LinkedList<>();
        }
        elements[index].add(value);
        size++;
    }

    private void ensureCapacity() {
        if ((double) size / elements.length > LOAD_FACTOR){
            List<T>[] newElements = new List[elements.length * 2];

        }
    }

    @Override
    public void remove(T value) {
        if (contains(value)) {
            int index = hash(value);
            elements[index].remove(value);
            size--;
        }
    }

    @Override
    public boolean contains(T value) {
        int index = hash(value);
        if (elements[index] == null) {
            return false;
        }
        return elements[index].contains(value);
    }

    private int hash(T value) {
        return value.hashCode() % elements.length;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(", ","[","]");
        for (List<T> list : elements) {
            if (list != null) {
                for (T j : list) {
                    sj.add(j.toString());
                }
            }

        }
        return sj.toString();
    }
}

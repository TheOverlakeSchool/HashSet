import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class HashIntSet implements IntSet {

    private int size;
    private List<Integer>[] elements;
    public static final int DEFAULT_CAPACITY = 11;
    public static final double LOAD_FACTOR = .75;

    @SuppressWarnings("unchecked")
    HashIntSet() {
        size = 0;
        elements = new List[DEFAULT_CAPACITY];
    }

    @Override
    public void add(int value) {
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
            List<Integer>[] newElements = new List[elements.length * 2];

        }
    }

    @Override
    public void remove(int value) {
        if (contains(value)) {
            int index = hash(value);
            elements[index].remove(Integer.valueOf(value));
            size--;
        }
    }

    @Override
    public boolean contains(int value) {
        int index = hash(value);
        if (elements[index] == null) {
            return false;
        }
        return elements[index].contains(value);
    }

    private int hash(int value) {
        return Math.abs(value) % elements.length;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(", ","[","]");
        for (List<Integer> list : elements) {
            if (list != null) {
                for (int j : list) {
                    sj.add(Integer.toString(j));
                }
            }

        }
        return sj.toString();
    }
}

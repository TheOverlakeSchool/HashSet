import java.util.Random;

public class HashIntSetClient {
    public static void main(String[] args) {
        IntSet set = new HashIntSet();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            set.add(random.nextInt(10));
        }
        System.out.println(set);
        System.out.println(set.contains(5));
        set.remove(5);
        System.out.println(set);

    }

}

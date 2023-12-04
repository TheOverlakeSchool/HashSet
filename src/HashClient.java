import java.util.Random;

public class HashClient {
    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            set.add(random.nextInt(10));
//        }
//        System.out.println(set);
//        System.out.println(set.contains(5));
//        set.remove(5);
//        System.out.println(set);

        Map<Integer, String> map = new HashMap<>();
        map.put(14, "Marty");
        map.put(21, "Jeff");
        System.out.println(map);

    }

}

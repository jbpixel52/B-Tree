import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
       // ArbolB BabyYoda = new randomTree();
        ArbolB b = new ArbolB<>(100);
        b.Insert(8);
        b.Insert(9);
        b.Insert(10);
        b.Insert(11);
        b.Insert(15);
        b.Insert(20);
        b.Insert(17);
        Random random = new Random();
        ArrayList<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int randomNumber = random.nextInt(100 - 0) + 0;
            randoms.add(randomNumber );
        }
        for (Integer integer : randoms) {
            b.Insert(integer);
        }
        b.Show();
    }

    
}

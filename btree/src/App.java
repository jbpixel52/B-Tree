import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
       // ArbolB BabyYoda = new randomTree();
        ArbolB b = new ArbolB<>(100);


        Random random = new Random();
        ArrayList<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 100; i++) 
        {
            int randomNumber = random.nextInt(200) + 0;
            
            while(randoms.contains(randomNumber))
            {
                randomNumber = random.nextInt(200) + 0;
            }
            randoms.add(randomNumber );
        }
        for (Integer integer : randoms) {
            b.Insert(integer);
        }
        b.Show();
    }

    
}

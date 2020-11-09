import java.util.ArrayList;
import java.util.Collections;

//https://www.youtube.com/watch?v=BSvbTqz2zbA

public class Main<T extends Comparable<T>> {

    public static void main(String[] args) {
        testCollectionsSort();
    }



    public static void  testCollectionsSort() {
        ArrayList<Integer> bomba = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            double random_double = Math.random() * (10 - 0 + 1) + 0;
            bomba.add((int) (random_double));
        }
        System.out.println("LISTA ANTES DE SORT con Collections");
        for (Integer integer : bomba) {
            System.out.println(integer);
        }
        Collections.sort(bomba);
        System.out.println("LISTA *DESPUES* DE SORT con Collections");
        
        for (Integer integer : bomba) {
            System.out.println(integer);
        }
    }
}
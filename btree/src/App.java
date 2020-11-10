

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
       // ArbolB BabyYoda = new randomTree();
        ArbolB b = new ArbolB<>(5);
        b.Insert(8);
        b.Insert(9);
        b.Insert(10);
        b.Insert(11);
        b.Insert(15);
        b.Insert(20);
        b.Insert(17);
        b.Show();
    }

    
}

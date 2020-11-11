import java.util.ArrayList;
import java.util.Random;

public class App 
{
    
    public static void main(String[] args) throws Exception 
    {
        ArbolB b = new ArbolB(3);
        b.insert(8);
        b.insert(9);
        b.insert(10);
        b.insert(11);
        b.insert(15);
        b.insert(20);
        b.insert(17);
    
        b.display();
    }
}

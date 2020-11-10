

public class randomTree<T extends ArbolB>{
    public ArbolB randomTree(int max, int min) {
        ArbolB arbol = new ArbolB((int) Math.random() * ((max - min) + 1) + min);
        for (int i = 0; i < 20; i++) {
            int r = (int) Math.random() * ((max - min) + 1) + min;
            //arbol.Insert(r);
        } 
        return arbol;
    }
}



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Nodo
 */
public class Nodo<T extends Comparable<T>> {
    // Cada nodo tiene a lo máximo m hijos.
    // M es el orden del arbol: Maximo número de hijos
    // Cada nodo que no sea hoja o raiz tiene m/2 hijos (5/2 = 2.5 = 3)
    // La raiz tiene dos hijos minimo si no es hoja (raiz sola)
    // Un nodo no hoja con k hijos tiene k-1 valores O tener k valores equivale
    // a tener k+1 hijos
    // Todas las hojas tienen la misma altura siempre
    private ArrayList<Nodo> kids; // pointers de hijos
    private ArrayList<T> values; //keys en otrros ejemplos
    public int T = 0; // orden minimo
    public int nKeys = 0; //numero de llaves
    public boolean leaf = false; //Es hoja si o no?

    public Nodo(int T, boolean leaf)
    {
        this.T = T;
        this.leaf = leaf;
        this.values  = new ArrayList<T>();
        this.kids = new ArrayList<Nodo>();
        this.nKeys = 0;//empieza vacio
        for (int i = 0; i < 2*T-1 ;i++)
            this.values.set(i, null);
        for (int i = 0; i < 2*T ;i++)  
            this.kids.set(i,null); 

    }

    
}

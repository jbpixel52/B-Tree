

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
    private ArrayList<Nodo> kids; // pointers
    private ArrayList<T> values = new ArrayList<T>();

    // private Nodo<T> next;

    public void Nodo() {
        this.kids = null;
        this.values = null;

    }

    public void addValue(T value) {
        this.values.add(value);
        // Ordenar hijos OrderValues();
    }

    public void addchild(Nodo child) {
        this.kids.add(child);
        Collections.sort((List<T>) this.kids);
    }

    public boolean isLeaf() {
        if (this.kids.isEmpty()) {
            return true;
        }
        return false;
    }
}

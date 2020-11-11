public class Btree<Key extends Comparable<Key>, Value>  {
    // hijos maximos por nodo = M - 1
    // (debe ser igual o mayor a 2)
    private static final int M = 4;

    private Node root;       // Raiz del arbol B
    private int height;      // Altura del arbol B
    private int n;           // numero de pares key-value en el arbol B


    private static final class Node {
        private int m;                             // Numero de hijos
        private Entry[] children = new Entry[M];   // arreglo de hijos

        // crea un nodo con k hijos
        private Node(int k) {
            m = k;
        }
    }

    //Nodo Interno: usa next y key
    //Nodo externo: usa key y value
    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next;
        public Entry(Comparable key, Object val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    /**
     * Inicializa un arbol B vacio
     */
    public Btree() {
        root = new Node(0);
    }
 
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public int height() {
        return height;
    }


    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return search(root, key, height);
    }

    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;

        // nodo externo
        if (ht == 0) {
            for (int j = 0; j < x.m; j++) {
                if (eq(key, children[j].key)) return (Value) children[j].val;
            }
        }

        // nodo interno
        else {
            for (int j = 0; j < x.m; j++) {
                if (j+1 == x.m || less(key, children[j+1].key))
                    return search(children[j].next, key, ht-1);
            }
        }
        return null;
    }


    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, val, height); 
        n++;
        if (u == null) return;

        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert(Node h, Key key, Value val, int ht) {
        int j;
        Entry t = new Entry(key, val, null);

        // nodo externo
        if (ht == 0) {
            for (j = 0; j < h.m; j++) {
                if (less(key, h.children[j].key)) break;
            }
        }

        // nodo interno
        else {
            for (j = 0; j < h.m; j++) {
                if ((j+1 == h.m) || less(key, h.children[j+1].key)) {
                    Node u = insert(h.children[j++].next, key, val, ht-1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.val = null;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.children[i] = h.children[i-1];
        h.children[j] = t;
        h.m++;
        if (h.m < M) return null;
        else         return split(h);
    }

    // divide el nodo a la mitad
    private Node split(Node h) {
        Node t = new Node(M/2);
        h.m = M/2;
        for (int j = 0; j < M/2; j++)
            t.children[j] = h.children[M/2+j]; 
        return t;    
    }

    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        }
        else {
            for (int j = 0; j < h.m; j++) {
                if (j > 0) s.append(indent + "(" + children[j].key + ")\n");
                s.append(toString(children[j].next, ht-1, indent + "     "));
            }
        }
        return s.toString();
    }


    // funciones de comparacion - hacen Comparable en lugar de Key para evitar casteos
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }


    public static void main(String[] args) {
        Btree<String, Integer> st = new Btree<String, Integer>();

        st.put("a",  1);
        st.put("b",     2);
        st.put("c",          3);
        st.put("d",      4);
        st.put("e",         5);
        st.put("f",        6);
        st.put("g",          7);
        st.put("h",           8);
        st.put("i",        9);
        st.put("j",      10);
        st.put("k",      11);
        st.put("l",         12);
        st.put("m",      13);
        st.put("n",         14);
        st.put("o",         15);
        st.put("p",         16);
        st.put("q",         17);
        st.put("r",         18);
        st.put("s",         19);
        st.put("t",         20);
        st.put("u",         21);
        st.put("v",         22);
        st.put("w",         23);
        st.put("x",         24);
        st.put("y",         25);
        st.put("z",         26);


        System.out.println(st.search(st.root, "j", st.height));

        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
    }

}

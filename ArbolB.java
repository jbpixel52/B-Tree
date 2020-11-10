import java.util.ArrayList;
public class ArbolB<T extends Comparable<T>> {

    private int T;
  
    // Node creation
    public class Node<T> {
      int n;
      T key[];
      Node<T> child[];
      boolean leaf = true;
  
      public int Find(T k) {
        for (int i = 0; i < this.n; i++) {
          if (this.key[i] == k) {
            return i;
          }
        }
        return -1;
      };
    }
  
    public ArbolB(int t) {
      T = t;
      root = new Node<T>();
      root.n = 0;
      root.leaf = true;
    }
  
    private Node<T> root;
  
    // Search key
    private Node<T> Search(Node<T> x, T key) {
      int i = 0;
      if (x == null)
        return x;
      for (i = 0; i < x.n; i++) {
        if (key.compareTo(x.key[i]) < 0) {
          break;
        }
        if (key == x.key[i]) {
          return x;
        }
      }
      if (x.leaf) {
        return null;
      } else {
        return Search(x.child[i], key);
      }
    }
  
    // Splitting the node
    private void Split(Node<T> x, int pos, Node<T> y) {
      Node<T> z = new Node<T>();
      z.leaf = y.leaf;
      z.n = T - 1;
      for (int j = 0; j < T - 1; j++) {
        z.key[j] = y.key[j + T];
      }
      if (!y.leaf) {
        for (int j = 0; j < T; j++) {
          z.child[j] = y.child[j + T];
        }
      }
      y.n = T - 1;
      for (int j = x.n; j >= pos + 1; j--) {
        x.child[j + 1] = x.child[j];
      }
      x.child[pos + 1] = z;
  
      for (int j = x.n - 1; j >= pos; j--) {
        x.key[j + 1] = x.key[j];
      }
      x.key[pos] = y.key[T - 1];
      x.n = x.n + 1;
    }
  
    // Inserting a value
    public void Insert(final T key) {
      Node<T> r = root;
      if (r.n == 2 * T - 1) {
        Node<T> s = new Node<T>();
        root = s;
        s.leaf = false;
        s.n = 0;
        s.child[0] = r;
        Split(s, 0, r);
        insertValue(s, key);
      } else {
        insertValue(r, key);
      }
    }
  
    // Insert the node
    final private void insertValue(Node<T> x, T k) {
  
      if (x.leaf) {
        int i = 0;
        for (i = x.n - 1; i >= 0 && k.compareTo(x.key[i]) < 0; i--) {
          x.key[i + 1] = x.key[i];
        }
        x.key[i + 1] = k;
        x.n = x.n + 1;
      } else {
        int i = 0;
        for (i = x.n - 1; i >= 0 && k.compareTo( x.key[i]) < 0; i--) {
        }
        ;
        i++;
        Node<T> tmp = x.child[i];
        if (tmp.n == 2 * T - 1) {
          Split(x, i, tmp);
          if (k.compareTo(x.key[i]) > 0) {
            i++;
          }
        }
        insertValue(x.child[i], k);
      }
  
    }
  
    public void Show() {
      Show(root);
    }
  
    // Display
    private void Show(Node<T> x) {
      assert (x == null);
      for (int i = 0; i < x.n; i++) {
        System.out.print(x.key[i] + " ");
      }
      if (!x.leaf) {
        for (int i = 0; i < x.n + 1; i++) {
          Show(x.child[i]);
        }
      }
    }
  
    // Check if present
    public boolean Contain(T k) {
      if (this.Search(root, k) != null) {
        return true;
      } else {
        return false;
      }
    }
  
    public void main(String[] args) {
      ArbolB<T> b = new ArbolB<T>(3);
      b.Insert(8);
      b.Insert(9);
      b.Insert(10);
      b.Insert(11);
      b.Insert(15);
      b.Insert(20);
      b.Insert(17);
  
      b.Show();
  
      if (b.Contain(12)) {
        System.out.println("\nfound");
      } else {
        System.out.println("\nnot found");
      }
      ;
    }
  }
  
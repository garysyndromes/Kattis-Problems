import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;


/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}


public class LostMaps {
  public static void main(String[] args) {
    FastIO fio = new FastIO();
    int n = fio.nextInt();
    // another graph data structure: EdgeList
    ArrayList < IntegerTriple > EdgeList = new ArrayList < IntegerTriple >();

    for (int i = 0 ; i < n ; i ++) {
        for (int j = 0; j < n ; j++) {
            int w = fio.nextInt();
            if (i >= j) {
                continue;
            } 
            EdgeList.add(new IntegerTriple(w, i, j));
        }
    }

    // sort by edge weight O(E log E)
    Collections.sort(EdgeList);


    // THE SECOND PART, THE MAIN LOOP OF KRUSKAL'S ALGORITHM
    UnionFind UF = new UnionFind(n); // all V are disjoint sets at the beginning
    int i, mst_cost = 0;
    for (i = 0; i < (n*n/2 - n/2); i++) { // process all edges, O(E)
      IntegerTriple e = EdgeList.get(i);
      int u = e.second(), v = e.third(), w = e.first(); // note that we have re-ordered the integer triple
      if (!UF.isSameSet(u, v)) { // if no cycle
        mst_cost += w; // add weight w of e to MST
        int x = u+1;
        int y = v+1;
        fio.println(x +" " + y );
        UF.unionSet(u, v); // link these two vertices
      }
    }
    fio.close();
  }
}



class IntegerTriple implements Comparable<IntegerTriple> {
  public Integer _first, _second, _third;

  public IntegerTriple(Integer f, Integer s, Integer t) {
    _first = f;
    _second = s;
    _third = t;
  }

  public int compareTo(IntegerTriple o) {
    if (!this.first().equals(o.first()))
      return this.first() - o.first();
    else if (!this.second().equals(o.second()))
      return this.second() - o.second();
    else
      return this.third() - o.third();
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
  Integer third() { return _third; }

  public String toString() { return first() + " " + second() + " " + third(); }
}



// Union-Find Disjoint Sets Library, using both path compression and union by rank heuristics
class UnionFind {
  public ArrayList<Integer> p, rank, setSize;
  public int numSets;

  public UnionFind(int N) {
    p = new ArrayList<Integer>();
    rank = new ArrayList<Integer>();
    setSize = new ArrayList<Integer>();
    numSets = N;
    for (int i = 0; i < N; i++) {
      p.add(i);
      rank.add(0);
      setSize.add(1);
    }
  }

  public int findSet(int i) { 
    if (p.get(i) == i) return i;
    else {
      int ret = findSet(p.get(i)); p.set(i, ret);
      return ret; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      numSets--; 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
      else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y)+1); } 
    } 
  }

  public int numDisjointSets() { return numSets; }

  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}

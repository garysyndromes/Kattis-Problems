import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

class UnionFind {                                              
  public int[] p;
  public int[] rank;
  public int numSets;
  public int[] numItems;
  public int[] sizeArray;
  public FastIO fio;

  public UnionFind(int N,FastIO fio) {
    p = new int[N+1];
    rank = new int[N+1];
    numSets = N;
    numItems = new int[N+1];
    sizeArray = new int[N+1];
    this.fio = fio;

    for (int i = 1; i < N+1; i++) {
      p[i] = i;
      rank[i] = 0;
      sizeArray[i] = 1;
    }

  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
     // System.out.println("Number of sets is " + numSets);
            // if numItems in the representative set < numDrawers in the representative set
             // print LADICA
             // else print SMECE
    int x = findSet(i), y = findSet(j);
    numItems[x] += 1;

    if (!isSameSet(i, j)) { 
      numSets--; 
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) {
          p[y] = x;
          numItems[x] += numItems[y];
          sizeArray[x] += sizeArray[y];
          numItems[y] = 0;

          if (sizeArray[x] >= numItems[x]) {
              fio.println("LADICA");
          } else {
              fio.println("SMECE");
              numItems[x] -= 1;
          }
        } else { 
      	p[x] = y;
        if (rank[x] == rank[y]) { 
          rank[y] = rank[y]+1;
        }
        numItems[y] += numItems[x];
        sizeArray[y] += sizeArray[x];
        numItems[x] = 0;
        if (sizeArray[y] >= numItems[y]) {
            fio.println("LADICA");
        } else {
            fio.println("SMECE");
            numItems[y] -= 1;
     } 
    }
 
  } else if (isSameSet(i, j)) {
      if (sizeArray[y] >= numItems[y]) {
        fio.println("LADICA");
    } else {
        fio.println("SMECE");
        numItems[y] -= 1;
    } 
   }

//   System.out.println(Arrays.toString(sizeArray) + " is sizeArray" + " x is " + x + " y is " + y);
    //  System.out.println(Arrays.toString(numItems) + " is numItems");
  }

  public int numDisjointSets() { return numSets; }
}   

public class Ladice {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int l = fio.nextInt();

        UnionFind disjointSet = new UnionFind(l,fio);
        
         for (int i = 0; i < n; i++) {
             int a = fio.nextInt();
             int b = fio.nextInt();
             //union
             disjointSet.unionSet(a,b);
            
        }

        fio.close();
    }

}



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


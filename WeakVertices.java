import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;


public class WeakVertices {
    public static void main (String[] args) {
            FastIO fio = new FastIO();
            int n = fio.nextInt();
            while (n != -1) {
            int[][] adjMatrix = new int[n][n];
            boolean[] matrixCheck = new boolean[n];

            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    int input = fio.nextInt();
                    adjMatrix[i][j] = input;
                }
            }

            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j ++) {
                    if (adjMatrix[i][j] == 1) {
                        for (int k = j+1; k < n; k++) {
                            if (adjMatrix[i][k] == 1) {
                                if (adjMatrix[j][k] == 1){
                                    matrixCheck[i] = true;
                                }
                            }

                        }
                    }
                }
            }
            for (int i = 0 ; i < n; i++) {
                if (matrixCheck[i] == false) {
                    fio.print(i + " ");
                }
            }
            
            fio.println();
            n = fio.nextInt();
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



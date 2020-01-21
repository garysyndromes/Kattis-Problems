import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Teque {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int[] a = new int[500000];
        int[] b = new int[500000];
        int aHead = 0;
        int bHead = 0;
        int aTail = 0;
        int bTail = 0;
        int aSize = 0;
        int bSize = 0;

        for (int i = 0; i < n; i++ ) {
            String method = fio.next();
            int x = fio.nextInt(); 

            if (method.equals("push_back")) {
            //    if (bHead == bTail && bHead == 0) {
            //         b[bHead] = x;
            //         bTail = (bTail + 1) % 500000;
            //         bSize = bSize + 1;
            //    } else {
                b[bTail] = x;
                bTail = (bTail + 1) % 500000;
                bSize = bSize + 1;
                    if ( bSize - aSize > 0) {
                        bSize = bSize - 1;
                        aSize = aSize + 1;
                        a[aTail] = b[bHead];
                        bHead = (bHead + 1) % 500000;
                        aTail = (aTail + 1) % 500000;

                     }
//               } 

            } else if (method.equals("push_front")) {
                // if (aHead == aTail && aHead == 0) {
                //   a[aHead] = x;
                //     aTail = aTail + 1 % 500000;
                //     aSize = aSize + 1;
                // } else {
                aHead = (aHead - 1 + 500000) % 500000;
                a[aHead] = x;
                aSize = aSize + 1;
                if (aSize - bSize > 1) {
                    aSize = aSize - 1;
                    bSize = bSize + 1;
                    bHead = (bHead - 1 + 500000) % 500000;
                    b[bHead] = a[(aTail - 1 + 500000) % 500000];
                    aTail = (aTail - 1 + 500000) % 500000;
                }

              //   }
            } else if (method.equals("push_middle")) {
                
                if (aSize <= bSize) {
                    a[aTail] = x;
                    aTail = (aTail + 1) % 500000;           
                    aSize = aSize + 1;

                } else {
              
                    bHead = (bHead - 1 + 500000) % 500000;
                    b[bHead] = x;
                    bSize = bSize + 1;
              
                }

            } else if (method.equals("get")) {
                    if (x < aSize) {
                        fio.println(a[(aHead + x) % 500000]);
                    } else {
                       fio.println(b[(bHead + (x - aSize)) % 500000]);

                    }
            } else {
                fio.println("Error in method");
            }
        }
        
    //   for (int i = 0; i < a.length ; i ++) {
    //        if ( a[i] != 0) {
    //             fio.println("this is in a :" + a[i] +" at index "+i+ " aHead is at " +aHead+" aTail is at " +aTail);
    //         }
    //         if (b[i] != 0) {
    //             fio.println("this is in b :" + b[i]+" at index "+i+" bHead is at " +bHead+" bTail is at " + bTail);
    //        }
    //     }    

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


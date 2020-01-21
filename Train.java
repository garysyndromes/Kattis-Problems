import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Train {

    public static void main(String[] args){
        FastIO fio = new FastIO();
        int capacity = fio.nextInt();
        int n = fio.nextInt();
        int onTrain = 0;


        for (int i = 0; i < n; i++) {
            int leftTrain = fio.nextInt();
            int enteredTrain = fio.nextInt();
            int hadToStay = fio.nextInt();
            if ((i == 0) && leftTrain > 0) {
                onTrain = 1;
                    break;    
            }
            onTrain += enteredTrain;
            onTrain -= leftTrain;
            if ((hadToStay != 0) && (onTrain != capacity)) {
                onTrain = 1;
                break;
            }
            if (onTrain > capacity) {
                onTrain = 1;
                break;
            }

        }

        if (onTrain == 0) {
            fio.println("possible");
        } else {
            fio.println("impossible");
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


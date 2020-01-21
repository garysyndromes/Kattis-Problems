import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class CardTrick {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();

        for (int i = 0; i < t ; i++) {
            int n = fio.nextInt();
            int output = 1;
            Queue<Integer> q = new LinkedList<>();
            for (int y = 0; y < n ; y++) {
                q.offer(0);
            }
            int numberOfTimes = 1;
            for (int x = 0; x < n ; x ++) {
                for (int c = 0; c < numberOfTimes ; c ++) {
                    while (q.peek() != 0) {
                        q.offer(q.poll());
                    }
                    q.offer(q.poll());
                }
               System.out.println(q);
                while (q.peek() != 0) {
                    q.offer(q.poll());
                }   
                q.poll();
                q.offer(output);
                System.out.println(q);
                output++;
                numberOfTimes++;

                
            }
            
            List<Integer> listOfOutput = new ArrayList<Integer>();
            while (q.size() != 0) {
                listOfOutput.add(q.poll());
            }

        
            List<Integer> duplicate = new ArrayList<Integer>();
            for ( int b = 0; b < listOfOutput.size(); b++) {
                    duplicate.add(listOfOutput.get(b));
            }

            for ( int g = 0 ; g < duplicate.size() ; g ++) {
                listOfOutput.add(duplicate.get(g));
            }



            for (int u = 1; u < listOfOutput.size(); u ++) {
                if (listOfOutput.get(u).equals(1)) {
                    int counter = 0;
                    for ( int a = u - 1; counter < n ; a++) { // index
                        fio.print(listOfOutput.get(a));
                        if (counter != n) {
                            fio.print(" ");
                        }
                        counter++;
                    }
                    break;
                }

            }
            if (i != t-1) {
            fio.println();
            }
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


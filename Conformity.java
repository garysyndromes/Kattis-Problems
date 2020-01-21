import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;


public class Conformity {
        public static void main(String[] args) {
            FastIO fio = new FastIO();
            int n = fio.nextInt();
            int[][] arrArr = new int[n][5];
            int popularity = 1;
            int output = 0;
            Map<String ,Integer> h = new HashMap<String, Integer>();
            
            for( int i = 0; i < n ; i++) {
                int c1 = fio.nextInt();
                int c2 = fio.nextInt();
                int c3 = fio.nextInt();
                int c4 = fio.nextInt();
                int c5 = fio.nextInt();

                arrArr[i][0] = c1;
                arrArr[i][1] = c2;
                arrArr[i][2] = c3;
                arrArr[i][3] = c4;
                arrArr[i][4] = c5;

            }

            for (int i = 0; i < n; i ++) {
                Arrays.sort(arrArr[i]);
                String str = Arrays.toString(arrArr[i]);
              


                if (h.containsKey(str)) {
                    int counter = h.get(str);
                    counter += 1;

                    h.put(str,counter);
                } else {
                    h.put(str,1);
                }   

                if (h.get(str) > popularity)  {
                    popularity = h.get(str);
                }

            }
            
           
            for (Map.Entry<String, Integer> entry : h.entrySet()) {
                if (entry.getValue() == popularity) {
                    output += entry.getValue();
                }

            }

            fio.println(output);

           // fio.println(output);
            //  fio.println(popularity);


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


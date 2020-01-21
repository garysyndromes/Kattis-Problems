import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;


public class JoinStrings {


    static void getOutput(int key,HashMap<Integer,ArrayList<Integer>> hashmap,ArrayList<String> list, ArrayList<String> outputList) {

         if (hashmap.get(key).size() == 1) {
            int index = hashmap.get(key).get(0);
       //     System.out.println("tihs is idndex: " + list.get(index - 1));
            outputList.add(list.get(index-1));
        } else {
                int idx = hashmap.get(key).get(0);
         //       System.out.println("this is idx : " + list.get(idx -1));
                outputList.add(list.get(idx - 1));
                for (int i = 1; i < hashmap.get(key).size() ; i ++) {
                    int nextKey = hashmap.get(key).get(i);
                    getOutput(nextKey,hashmap,list,outputList); 
                    }
 
                
        }


    }

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        ArrayList<String> strings = new ArrayList<String>();
        HashSet h = new HashSet();
        int n = fio.nextInt();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();


        for (int i = 0; i < n ; i++) {
            String string = fio.nextLine();
            strings.add(string);
            h.add(i+1);
        }
        
        for ( int x = 1; x <= n ; x ++ ) {
            int key = x;
            map.put(x, new ArrayList<Integer>());
            map.get(key).add(x);
        }

        for ( int y = 1; y < n ; y++) {
            int a = fio.nextInt();
            int b = fio.nextInt();
            map.get(a).add(b);
            h.remove(b);
        }
        int initialKey = 0;

        for (int q = 1 ; q < n ; q ++) {
            if (h.contains(q)){
                initialKey = q;
                break;
            }
        }
        ArrayList<String> output = new ArrayList<String>();
        getOutput(initialKey,map,strings,output);

       for ( int k = 0; k < output.size() ; k ++) {
           fio.print(output.get(k));
        }


        
  //      for(int x = 0; x < strings.size(); x++) {
    //        if (!(strings.get(x).equals(""))) {
       //         fio.println(strings.get(x));
     //       }
      //  }

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


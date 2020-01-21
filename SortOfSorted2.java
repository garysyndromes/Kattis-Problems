import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SortOfSorted2 {

    public static String[] mergeSort(String[] arr) {
        // if array length is 1 -> return arr
        if (arr.length == 0) {
            return arr;
        }

        String[] firstHalf = Arrays.copyOfRange(arr, 0, (arr.length / 2) + 1);
        String[] secondHalf = Arrays.copyOfRange(arr, (arr.length / 2) + 1, arr.length);
        String[] newFirstHalf = mergeSort(firstHalf);        
        String[] newSecondHalf = mergeSort(secondHalf);

       // merge two sorted into one 
        String[] merged = new String[arr.length];
        int a = 0;
        int b = 0;
        int mergePointer = 0;
        while ((a < firstHalf.length) && ( b < secondHalf.length)) {
            int temp = newFirstHalf[a].charAt(0) - newSecondHalf[b].charAt(0);
            if (temp < 0) {
                merged[mergePointer] = newFirstHalf[a];
                mergePointer++;
                a++;
            } else if (temp > 0) {
                merged[mergePointer] = newSecondHalf[b];
                mergePointer++;
                b++;
            } else {
                int temp2 = newFirstHalf[a].charAt(1) - newSecondHalf[b].charAt(1);
                if (temp2 <= 0) {
                    merged[mergePointer] = newFirstHalf[a];
                    mergePointer++;
                    a++;
                } else {
                    merged[mergePointer] = newSecondHalf[b];
                    mergePointer++;
                    b++;
            }
        }

        if (a == newFirstHalf.length) {
            for (int i = mergePointer; i < merged.length; i++) {
                merged[i] = newSecondHalf[b];
                b++;
            }
        }
        if (b == newSecondHalf.length) {
            for (int i = mergePointer; i < merged.length; i++) {
                merged[i] = newSecondHalf[a];
                a++;
            }
        }
      
    }
    return merged;
}

    
    public static void main(String[] args){
        FastIO fio = new FastIO();
        int n = fio.nextInt();

        while (n != 0) {
            String[] studentList = new String[n];
            for(int i = 0; i < n; i++){
                studentList[i] = (fio.nextLine());
            }
           String[] mergedStudentList = mergeSort(studentList);

            for (int i = 0; i < n; i++) {
                fio.println(mergedStudentList[i]);
            }
            n = fio.nextInt();
            if (n != 0){
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


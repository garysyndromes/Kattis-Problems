import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class PhoneKeypad {

    public static void main(String args[]) {
    FastIO fio = new FastIO();
    int N = fio.nextInt();
    
   // String[] array = {"2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","8","88","888","9","99","999"}
     //       String d = array['d' - 'a'];

    for(int i = 0; i < N; i++) {
        String input = fio.nextLine();
        int strlength = input.length();
        StringBuilder sb = new StringBuilder();
        String lastButtonPress = " ";
        for (int y = 0; y < strlength; y++) {
            char c = input.charAt(y);
            switch (c) {
                case 'a':
                  if (lastButtonPress.equals("2")) {
                      sb.append(" ");
                  }
                  sb.append("2");
                  lastButtonPress = "2";
                  break;
                case 'b':

                  if (lastButtonPress.equals("2")) {
                      sb.append(" ");
                  }
                  sb.append("22");
                  lastButtonPress = "2";
                  break;
                case 'c':

                if (lastButtonPress .equals ("2")) {
                    sb.append(" ");
                }
                sb.append("222");
                lastButtonPress = "2";
                break;
                case 'd':

                if (lastButtonPress .equals ("3")) {
                    sb.append(" ");
                }
                sb.append("3");
                lastButtonPress = "3";
                break;
                case 'e':

                if (lastButtonPress .equals ("3")) {
                    sb.append(" ");
                }
                sb.append("33");
                lastButtonPress = "3";
                break;

                case 'f':

                if (lastButtonPress .equals ("3")) {
                    sb.append(" ");
                }
                sb.append("333");
                lastButtonPress = "3";
                break;

                case 'g':
                if (lastButtonPress .equals ("4")) {
                    sb.append(" ");
                }
                sb.append("4");
                lastButtonPress = "4";
                break;

                case 'h':
                if (lastButtonPress .equals ("4")) {
                    sb.append(" ");
                }
                sb.append("44");
                lastButtonPress = "4";
                break;

                case 'i':
                if (lastButtonPress .equals ("4")) {
                    sb.append(" ");
                }
                sb.append("444");
                lastButtonPress = "4";
                break;

                case 'j':
                if (lastButtonPress .equals ("5")) {
                    sb.append(" ");
                }
                sb.append("5");
                lastButtonPress = "5";
                break;

                case 'k':
                if (lastButtonPress .equals ("5")) {
                    sb.append(" ");
                }
                sb.append("55");
                lastButtonPress = "5";
                break;

                case 'l':
                if (lastButtonPress .equals ("5")) {
                    sb.append(" ");
                }
                sb.append("555");
                lastButtonPress = "5";
                break;

                case 'm':
                if (lastButtonPress .equals ("6")) {
                    sb.append(" ");
                }
                sb.append("6");
                lastButtonPress = "6";
                break;

                case 'n':
                if (lastButtonPress .equals ("6")) {
                    sb.append(" ");
                }
                sb.append("66");
                lastButtonPress = "6";
                break;

                case 'o':
                if (lastButtonPress .equals ("6")) {
                    sb.append(" ");
                }
                sb.append("666");
                lastButtonPress = "6";
                break;

                case 'p':
                if (lastButtonPress .equals ("7")) {
                    sb.append(" ");
                }
                sb.append("7");
                lastButtonPress = "7";
                break;
                
                case 'q':
                if (lastButtonPress .equals ("7")) {
                    sb.append(" ");
                }
                sb.append("77");
                lastButtonPress = "7";
                break;
                
                case 'r':
                if (lastButtonPress .equals ("7")) {
                    sb.append(" ");
                }
                sb.append("777");
                lastButtonPress = "7";
                break;

                case 's':
                if (lastButtonPress .equals ("7")) {
                    sb.append(" ");
                }
                sb.append("7777");
                lastButtonPress = "7";
                break;

                case 't':
                if (lastButtonPress .equals ("8")) {
                    sb.append(" ");
                }
                sb.append("8");
                lastButtonPress = "8";
                break;

                case 'u':
                if (lastButtonPress .equals ("8")) {
                    sb.append(" ");
                }
                sb.append("88");
                lastButtonPress = "8";
                break;

                case 'v':
                if (lastButtonPress .equals ("8")) {
                    sb.append(" ");
                }
                sb.append("888");
                lastButtonPress = "8";
                break;

                case 'w':
                if (lastButtonPress .equals ("9")) {
                    sb.append(" ");
                }
                sb.append("9");
                lastButtonPress = "9";
                break;

                case 'x':
                if (lastButtonPress .equals ("9")) {
                    sb.append(" ");
                }
                sb.append("99");
                lastButtonPress = "9";
                break;

                case 'y':
                if (lastButtonPress .equals ("9")) {
                    sb.append(" ");
                }
                sb.append("999");
                lastButtonPress = "9";
                break;

                case 'z':
                if (lastButtonPress .equals ("9")) {
                    sb.append(" ");
                }
                sb.append("9999");
                lastButtonPress = "9";
                break;

                case ' ':
                if (lastButtonPress .equals ("0")) {
                    sb.append(" ");
                }
                sb.append("0");
                lastButtonPress = "0";
                break;
            }
        

        }


        fio.println("Case #"+(i+1)+": "+sb)  ; 
       
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


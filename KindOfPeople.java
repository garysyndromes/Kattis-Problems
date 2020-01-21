import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;


public class KindOfPeople {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        int c = fio.nextInt();
        Node[][] map = new Node[r][c];
     //   int[][] p = new int [r][c];
        
        for (int i = 0 ; i < r ; i++) {
            String input = fio.nextLine();
            for (int j = 0; j < c ; j ++) {
                map[i][j] =  new Node(input.charAt(j),i,j);
              //  p[i][j] = -1;

            }

        }

        int area = 0;
        Queue<Node> q = new LinkedList<>();
 
        for (int k = 0; k < r ; k ++ ){
            for (int j = 0; j < c ; j++) {
                Node now = map[k][j];
             if (now.visited == false) {
                now.visit();
                now.setArea(area);
                q.offer(now);
              while (q.size() != 0) {
            
            Node current = q.poll();
         //  fio.println(current);
            int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            for (int i = 0; i < move.length; i++) {
                int thisRow = current.getR();
                int thisCol = current.getC();
                int nextRow = current.getR() + move[i][0];
                int nextCol = current.getC() + move[i][1];
                if ( nextRow >= r || nextRow < 0 || nextCol < 0 || nextCol >= c) {
                    continue;
                }
                Node next = map[nextRow][nextCol];

                if (next.visited == false && next.value == current.value) {
                    next.visit();
                    next.setArea(current.area);
                    q.offer(next);
                }
            }
                
            }
            area++;
        }
    }
}

        

        int n = fio.nextInt();

        for (int i = 0; i < n ; i ++) {
            int r1 = fio.nextInt() - 1;
            int c1 = fio.nextInt() - 1;
            int r2 = fio.nextInt() - 1;
            int c2 = fio.nextInt() - 1;
            
            Node source = map[r1][c1];
            Node dest = map[r2][c2];

            
            if (source.value == '1' && dest.value == '1') {
                if (source.area == dest.area) {
                    fio.println("decimal");
                } else {
                    fio.println("neither");
                }
            } else if (source.value == '0' && dest.value == '0') {
                if (source.area == dest.area) {
                    fio.println("binary");
                } else {
                    fio.println("neither");
                }
            } else {
                fio.println("neither");
            }

        //    fio.println("source value is " +source.value +" dest value is " + dest.value);
       //     fio.println("source area is " + source.area + " dest area is " + dest.area);

        }
        fio.close();
    }
}

class Node {
   public char value;
     int i;
     int j;
    public boolean visited = false;
    public int area;

    Node(char value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
        this.area = area;
    }
    public void visit() {
        this.visited = true;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getR() {
        return i;
    }
    public int getC() {
        return j;
    }

    @Override
    public String toString() {
        return "(" + value + " " + i + " " + j + " " + area + ") " + visited;
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


import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;


public class Islands {
    public static int dfs(char[][] picture,int[][] visited,int row, int column, int srcR, int srcC) {
        int r = row;
        int c = column;
        int sourceRow = srcR;
        int sourceC = srcC;
    
                if (visited[sourceRow][sourceC] == 0) {       
                visited[sourceRow][sourceC] = 1;

                // int[] directionR = { -1 , 1 , 0 , 0}; // up, down, left,right
                // int[] directionC = { 0, 0, -1, 1};

                // for (int i = 0; i < 4; i++) {
                //     int x = srcR + directionR[i];
                //     int y = srcC + directionC[i];
                //     if ( x < 0 || y < 0 || x >= r || y >= c) {
                //         continue;
                //     }

                //     if (( picture[x][y] == 'C' || picture[x][y] == 'L') && visited[x][y] == 0 ) {
                //         dfs(picture,visited,r,c,x,y);
                //     }
                    


                // }
                    

                    if ( (!(sourceC + 1 >= c)) && (visited[srcR][sourceC+1] == 0) && (picture[srcR][sourceC+1] == 'C' || picture[srcR][sourceC+1] == 'L')) { //go right
                        dfs(picture,visited,r,c,srcR,sourceC+1);
                    }
                    if ((!(sourceC - 1 < 0)) && (visited[srcR][sourceC-1] == 0) && (picture[srcR][sourceC-1] == 'C' || picture[srcR][sourceC-1] == 'L')) { //go left
                        dfs(picture,visited,r,c,srcR,sourceC-1);
                     } 
                     if ((!(srcR - 1 < 0)) && (visited[srcR - 1][sourceC] == 0) && (picture[srcR - 1][sourceC] == 'C' || picture[srcR-1][sourceC] == 'L')) { //go up
                        dfs(picture,visited,r,c,srcR-1,sourceC);
                    } 
                     if ((!(srcR + 1 >= r)) && (visited[srcR+1][sourceC] == 0) && (picture[srcR+1][sourceC] == 'C' || picture[srcR+1][sourceC] == 'L')) { //go down
                        dfs(picture,visited,r,c,srcR+1,sourceC);
                 } 
        }
        return 0;   
    }
    



    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int r = fio.nextInt();
        int c = fio.nextInt();
        char[][] image = new char[r][c];
        int[][] visited = new int[r][c];
        int counter = 0;

        for(int i = 0; i < r ; i ++) {
            char[] temp = fio.nextLine().toCharArray();
            for (int j = 0; j < c; j++) {
                image[i][j] = temp[j];
                visited[i][j] = 0;
            }

        }

        for ( int i = 0; i < r ; i ++) {
            for (int j = 0; j < c ; j ++) {
            if (image[i][j] == 'L' && visited[i][j] == 0) {
                dfs(image,visited,r,c,i,j);
                counter++;
            }
        }
    }
        
        fio.print(counter);
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


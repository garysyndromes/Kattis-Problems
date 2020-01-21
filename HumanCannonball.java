import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class HumanCannonball {
    public static final int INF = 1000000000;
    public static ArrayList< Integer > D = new ArrayList< Integer >();
    public static ArrayList< Integer > p = new ArrayList< Integer >() ;
    
    public static void init_SSSP(int s,int V) { // initialization phase
      D.clear();
      D.addAll(Collections.nCopies(V, INF)); // use 1B to represent INF
      p.clear();
      p.addAll(Collections.nCopies(V, -1)); // use -1 to represent NULL
      D.set(s, 0); // this is what we know so far
    }
  


    public static void main(String[] args) {
        FastIO fio = new FastIO();
        ArrayList<Node> items = new ArrayList<>();
        double startX = fio.nextDouble();
        double startY = fio.nextDouble();
        double endX = fio.nextDouble();
        double endY = fio.nextDouble();
        Node startNode = new Node(startX,startY,"Start");  
        items.add(startNode);
        
        int numCannons = fio.nextInt();
        int V = numCannons + 2;
        double[][] timings = new double[V][V];

        for (int i = 0; i < numCannons; i++) {
            double cannonX = fio.nextDouble();
            double cannonY = fio.nextDouble();
            Node cannon = new Node(cannonX,cannonY,"Cannon");
            items.add(cannon);
        }
        Node endNode = new Node(endX,endY,"End");
        items.add(endNode);
        
        for (int i = 0; i < numCannons+2; i++) {
            for (int j = 0; j < numCannons+2; j++) {
                if (i == j) {
                    timings[i][j] = 0;
                    continue;
                }
                Node src = items.get(i);
                Node dest = items.get(j);

                if (src.type == "Start" || src.type == "End") {
                    double strLineDist = src.strLineDistTo(dest);
                    double timingToWalkFromSrc = strLineDist / 5;
                    timings[i][j] = timingToWalkFromSrc;
                }
                
                if (src.type == "Cannon") {
                    double strLineDistCannon = src.strLineDistTo(dest);
                    double timingToWalkFromSrc = strLineDistCannon / 5;
                    double timingToFireThenWalkFromSrc = 2;
                    if (strLineDistCannon > 50) {
                       strLineDistCannon = strLineDistCannon - 50;
                       timingToFireThenWalkFromSrc += strLineDistCannon / 5;
                       
                    } else {
                        strLineDistCannon = 50 - strLineDistCannon;
                        timingToFireThenWalkFromSrc += strLineDistCannon / 5;
                    }
                    if (timingToWalkFromSrc < timingToFireThenWalkFromSrc) {
                        timings[i][j] = timingToWalkFromSrc;
                    } else {
                        timings[i][j] = timingToFireThenWalkFromSrc;
                    }

                }


            }
        }

        		//ALL PATH SHORTEST PATH FLOYD MAYWEATHER!! 
			for (int k=0; k<V; k++) {

			    for (int i=0; i<V; i++) {
                  
				    for (int j=0; j<V; j++) {
                    timings[i][j] = Math.min(timings[i][j], timings[i][k] + timings[k][j]);
                }
            }
        }


		
		fio.println(timings[0][V-1]);
        // init_SSSP(0,V);
        // PriorityQueue<IntegerPair> pq = new PriorityQueue<IntegerPair>();
        // pq.offer(new IntegerPair(0, 0)); // distance from src,src node
        // while (!pq.isEmpty()) {
        //     IntegerPair top = pq.poll();
        //     int d = top.first(),
        //     u = top.second();
        //     if (d == D.get(u)) {
        //         for (int i = 0; i < V; i ++) {

        //         }
        //     }

        // }


        fio.close();


    }
}

class Node {
    double x;
    double y;
    String type;
    int count = -1;

    Node(double x, double y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        count++;
    }

    public double strLineDistTo(Node n) {
        return Math.sqrt(Math.pow(this.x - n.x,2) + Math.pow(this.y - n.y, 2));
    } 
    

}


class IntegerPair implements Comparable<IntegerPair> {
    Integer _first, _second;
  
    public IntegerPair(Integer f, Integer s) {
      _first = f;
      _second = s;
    }
  
    public int compareTo(IntegerPair o) {
      if (!this.first().equals(o.first()))
        return this.first() - o.first();
      else
        return this.second() - o.second();
    }
  
    Integer first() { return _first; }
    Integer second() { return _second; }
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


import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;



public class AssigningWorkstations {
    public static void main(String[] args) {
    FastIO fio = new FastIO();
    int n = fio.nextInt();
    int m = fio.nextInt();
    int count = 0; // number of times she unlocks the door
    Comparator<Researcher> rComparator = new Comparator<Researcher>() {
        @Override
        public int compare(Researcher r1, Researcher r2) {
            if (r1.a < r2.a){
                return -1;
            } else if ( r1.a > r2.a) {
                return 1;
            } else {
                return r1.stay - r2.stay;
            }
        }
    };
    Comparator<Integer> wComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer w1, Integer w2) {
            return w1 - w2;
        }
    };
    PriorityQueue<Researcher> rPQ = new PriorityQueue<Researcher>(rComparator);
    PriorityQueue<Integer> wPQ = new PriorityQueue<Integer>(wComparator);


    for(int i = 0; i < n; i++) {
    int arrives = fio.nextInt();
    int stays = fio.nextInt();
    Researcher r = new Researcher(arrives, stays);
    rPQ.add(r);
    } 

    
    if (rPQ.size() != 0) {
        if (wPQ.size() == 0) {
            count += 1;
            Researcher firstResearcher = rPQ.poll();
            wPQ.add(firstResearcher.getTotalTime());
        }
        while (rPQ.size() != 0) {

            Researcher nextResearcher = rPQ.poll();
            Integer currentEndingTiming = wPQ.poll();
      //      System.out.println("currentEndingTiming is :" +currentEndingTiming);
       //     System.out.println("nextResearcher arrival time is : " +nextResearcher.getArrivalTime());
            if (nextResearcher.getArrivalTime() < currentEndingTiming) {
                count += 1;
                wPQ.add(nextResearcher.getTotalTime());
                wPQ.add(currentEndingTiming);
            } else if (nextResearcher.getArrivalTime() - currentEndingTiming <= m) {
                currentEndingTiming = nextResearcher.getTotalTime();
                wPQ.add(currentEndingTiming);    
                            
            } else if (currentEndingTiming + m < nextResearcher.getArrivalTime()) {
                while (wPQ.size() != 0) {
                   int nextEarliestEndingTiming = wPQ.poll();
                if (nextResearcher.getArrivalTime() < nextEarliestEndingTiming) {
                    count += 1;
                    wPQ.add(nextResearcher.getTotalTime());
                    wPQ.add(nextEarliestEndingTiming);
                    break;
                } else if (nextResearcher.getArrivalTime() - nextEarliestEndingTiming <= m) {
                    nextEarliestEndingTiming = nextResearcher.getTotalTime();
                    wPQ.add(nextEarliestEndingTiming);   
                    break;
                }
                }
                if (wPQ.size() == 0) {
                    count+= 1;
                    wPQ.add(nextResearcher.getTotalTime());
                }
            }
        }
    } 




    int saved = n - count;
 //   fio.println("n is : "+n);
  //  fio.println("count is : " +count);
    fio.print(saved);
    fio.close();
    }
}

class Researcher {
   protected int a;
    protected int stay;

    Researcher(int a, int stay) {
        this.a = a;
        this.stay = stay;
    }

    public int getTotalTime() {
        return a + stay;
    }

    public int getArrivalTime() {
        return a;
    }
    @Override
    public String toString() {
        return a+" "+stay;
    }
}

class WorkStations {
    int m;
    int workStationNum;

    WorkStations(int m) {
        this.m = m;
        workStationNum++;
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


import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Relay {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        List<Runner> listOfRunners = new ArrayList<Runner>();
       

        Comparator<Runner> comp1 = new Comparator<Runner>() {
        @Override
        public int compare(Runner r1, Runner r2) {
            double result = r1.getFirstLeg() - r2.getFirstLeg();
            int output = (int) result ;
            if (result <= 0) {
                return -1;
            } else if (result > 0) {
                return 1;
            }
            return 0;
                }
        };

        Comparator<Runner> comp2 = new Comparator<Runner>() {
            @Override
            public int compare(Runner r1, Runner r2) {
                double result = r1.getOtherLegs() - r2.getOtherLegs();
                if (result <= 0) {
                    return -1;
                } else if (result > 0) {
                    return 1;
                }
                return 0;
                }
            };
            
        for (int i = 0; i < n ; i++) {
            String name = fio.next();
            double oneLeg = fio.nextDouble();
            double restLeg = fio.nextDouble();
            Runner runner = new Runner(name, oneLeg, restLeg);
            listOfRunners.add(runner);
        }
            Collections.sort(listOfRunners, comp2); // assume sorted according to last leg

        double fastestTeamTime = 80.0;
        List<Runner> finalTeam = new ArrayList<Runner>();
        for (int i = 0; i < n ; i ++) {
            double teamTotalTime = 0;
            List<Runner> lineUp = new ArrayList<Runner>();
            lineUp.add(listOfRunners.get(i));
            teamTotalTime += lineUp.get(0).getFirstLeg();

            for (int y = 0; y < n ; y++) {
                if (lineUp.size() == 4) {
                    if (teamTotalTime < fastestTeamTime) {
                        fastestTeamTime = teamTotalTime;
                        finalTeam = lineUp;
                    }
                    break;
                }
                if (listOfRunners.get(i).equals(listOfRunners.get(y))) {
                    continue;
                }
                lineUp.add(listOfRunners.get(y));
                teamTotalTime += listOfRunners.get(y).getOtherLegs();
            }

        }


    //    fio.println(firstLegRunner);
    // double totalTiming = lineUp.get(0).getFirstLeg() + lineUp.get(1).getOtherLegs() + lineUp.get(2).getOtherLegs() + lineUp.get(3).getOtherLegs();
        
      fio.printf("%.2f",fastestTeamTime);
       fio.println();
       for (int i = 0; i < 4 ; i++) {
            fio.println(finalTeam.get(i));
        }

            
        fio.close();
        }

    }


 class Runner {
    String name;
    double firstLeg;
    double otherLegs;

    public Runner(String name, double firstLeg, double otherLegs) {
        this.name = name;
        this.firstLeg = firstLeg;
        this.otherLegs = otherLegs;
    }

    public String getName() {
        return name;
    }

    public double getFirstLeg() {
        return firstLeg;
    }

    public double getOtherLegs() {
        return otherLegs;
    }
    @Override
    public String toString() {
        return name;
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


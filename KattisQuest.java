import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class KattisQuest {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        Comparator<Quest> qComparator = new Comparator<Quest>(){
            public int compare(Quest q1, Quest q2) {
                if (q1.energy != q2.energy) {
                    return q1.energy - q2.energy;
                } else {
                    return q1.gold - q2.gold;
                }
            }
        };
        
        TreeMap<Quest,Integer> treeMap = new TreeMap<Quest,Integer>(qComparator);
        
        for(int i = 0;i < n; i++) {
            String string = fio.next();
            if (string.equals("add")) {
                int energy = fio.nextInt();
                int gold = fio.nextInt();
                Quest quest = new Quest(energy,gold);
                if (treeMap.containsKey(quest)){
                    int counter = treeMap.get(quest) + 1;
                    treeMap.remove(quest);
                    treeMap.put(quest,counter);
                } else {
                treeMap.put(quest,1);
                }

            } else if (string.equals("query")) {
                int energyQuery = fio.nextInt();
                long currentGold = 0;

                while (energyQuery > 0 && (treeMap.floorKey(new Quest(energyQuery, 100001)) != null ))     {
                    Quest q = treeMap.floorKey(new Quest(energyQuery, 100001));
                    currentGold += q.gold;
                    energyQuery -= q.energy;
                   // fio.println("energy left is" + energyQuery);
                    if (treeMap.get(q).equals(1)) {
                        treeMap.remove(q);
                    } else {
                        int counter = treeMap.get(q) - 1;
                        treeMap.remove(q);
                        treeMap.put(q,counter);
                    }
                }
                fio.println(currentGold);


            } else {
                fio.println("Error in switching");
            }
        }


        fio.close();
    }
}

class Quest {
    int energy;
    int gold;

    public Quest(int energy, int gold){
        this.energy = energy;
        this.gold = gold;
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


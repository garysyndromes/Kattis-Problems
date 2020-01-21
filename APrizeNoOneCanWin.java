import java.util.*;


public class APrizeNoOneCanWin {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> costOfItems = new ArrayList<Integer>();
    int numberOfItems = sc.nextInt();
    if (numberOfItems == 1) {
        System.out.println(numberOfItems);
    } else {
        int output = 1;
        int minimumCost = sc.nextInt();
        for (int i = 0; i < numberOfItems; i ++) {
            int item = sc.nextInt();
            costOfItems.add(item);
        }
        Collections.sort(costOfItems);
        
        for (int i = 0; i < numberOfItems; i ++) {
            if ( i + 1 >= numberOfItems ) {
                break;
            } 
                int itemOne = costOfItems.get(i);
                int itemTwo = costOfItems.get(i+1);
                if ((itemOne + itemTwo) <= minimumCost) {
                    output ++;
                }

        }
        System.out.println(output);
         
    }
    }
}
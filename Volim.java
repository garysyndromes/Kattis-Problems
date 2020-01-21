import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        boolean hasExploded = false;
        int totalTime = 210;
        for (int i = 0; i< n; i++) {
            int time = scanner.nextInt();
            String z = scanner.next();
            totalTime -= time;
            if (totalTime < 0) {
                hasExploded = true;
                break;
            }

            if (z.equals("T")) {
                k += 1;
            } 
           
 

        }
        
        while (k > 8) {
            k -= 8;
        }

        if ( k == 0) {
            k = 1;
        }

        System.out.println(k);

    }
}
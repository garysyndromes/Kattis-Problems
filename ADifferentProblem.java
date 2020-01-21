import java.util.*;

class ADifferentProblem {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLong()) {
    long m = sc.nextLong();
    long n = sc.nextLong();
    long output;

    if (m > n) {
        output = m - n;
    } else {
        output = n - m;
    }

    System.out.println(output);
    }
}
}
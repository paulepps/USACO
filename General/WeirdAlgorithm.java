package General;
import java.util.*;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        System.out.print(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            System.out.print(" " + n);
        }
        System.out.println();
    }    
}

package algorithm_basics_one._300;

import java.util.Scanner;

public class CombinationCountZero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();

        long count5 = count(n, 5) - count(n - m, 5) - count(m, 5);
        long count2 = count(n, 2) - count(n - m, 2) - count(m, 2);

        System.out.println(Math.min(count5, count2));
    }

    public static long count(long n, long t) {
        long count = 0;
        while (n >= t) {
            count += n / t;
            n /= t;
        }
        return count;
    }
}

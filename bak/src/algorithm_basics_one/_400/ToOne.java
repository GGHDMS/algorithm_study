package algorithm_basics_one._400;

import java.util.Scanner;

public class ToOne {

    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        calc(0, n);

        System.out.println(minCount);
    }

    public static void calc(int count, int n) {
        if (minCount <= count) {
            return;
        }

        if (n == 1) {
            minCount = count;
        }

        if (n % 3 == 0) {
            calc(count + 1, n / 3);
        }

        if (n % 2 == 0) {
            calc(count + 1, n / 2);
        }

        calc(count + 1, n - 1);
    }
}

package algorithm_basics_one._300;

import java.util.Scanner;

public class GL {

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd;
        if (a < b) {
            gcd = gcd(b, a);
        } else {
            gcd = gcd(a, b);
        }

        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }
}

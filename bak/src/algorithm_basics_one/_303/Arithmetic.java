package algorithm_basics_one._303;

import java.util.Scanner;

public class Arithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (n >= b) {
            int k = n % b;
            if (k >= 10) {
                sb.append((char) ('A' + (k - 10)));
            } else {
                sb.append(k);
            }
            n = n / b;
        }

        if (n >= 10) {
            sb.append((char) ('A' + (n - 10)));
        } else {
            sb.append(n);
        }
        System.out.println(sb.reverse());
    }
}

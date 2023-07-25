package algorithm_basics_one._303;

import java.util.Scanner;

public class Factorization {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int b = 2;
        while (n != 1) {
            if (n % b == 0) {
                sb.append(b).append('\n');
                n /= b;
            } else {
                b++;
            }
        }

        System.out.println(sb);
    }
}

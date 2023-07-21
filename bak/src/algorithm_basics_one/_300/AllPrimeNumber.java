package algorithm_basics_one._300;

import java.util.Scanner;

public class AllPrimeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int[] check = new int[b + 1];

        for (int i = 2; i <= b; i++) {
            if (check[i] == 0 && i >= a) {
                sb.append(i).append("\n");
            }
            for (int j = i; j <= b; j += i) {
                check[j] = 1;
            }
        }

        System.out.println(sb);
    }
}

package algorithm_basics_one._400;

import java.util.Scanner;

public class SumOfSquares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[100_001];

        for (int i = 1; i <= 100_000; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= 100_000; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        System.out.println(dp[n]);

    }
}

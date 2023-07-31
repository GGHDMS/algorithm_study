package algorithm_basics_one._400;

import java.util.Scanner;

public class SumDecomposition {

    static int mod = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[][] dp = new long[201][201];

        for (int i = 1; i <= 200; i++) {
            dp[i][1] = 1;
        }

        for (int j = 1; j <= 200; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= 200; i++) {
            for (int j = 2; j <= 200; j++) {
                long sum = 0;
                for (int m = 1; m <= i; m++) {
                    sum += dp[m][j - 1] % mod;
                }
                dp[i][j] = (sum + 1) % mod;
            }
        }

        System.out.println(dp[n][k]);
    }
}

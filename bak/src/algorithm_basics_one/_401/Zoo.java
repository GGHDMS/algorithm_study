package algorithm_basics_one._401;

import java.util.Scanner;

public class Zoo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] dp = new int[100_001][2];

        dp[1][0] = 1;
        dp[1][1] = 2;

        for (int i = 2; i <= 100_000; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % 9901;
        }

        System.out.println((dp[n][0] + dp[n][1]) % 9901);

    }
}

package algorithm_basics_one._400;

import java.util.Scanner;

public class NumberOfSteps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[][] dp = new long[101][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8];
                } else {
                    dp[i][j] = (dp[i - 1][j-1] + dp[i -1][j+1]) % 1_000_000_000;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % 1_000_000_000);
    }

}

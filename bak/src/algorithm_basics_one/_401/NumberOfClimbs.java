package algorithm_basics_one._401;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfClimbs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[1_001][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 1_000; i++) {
            for (int j = 0; j <= 9; j++) {
                int sum=0;
                for (int k = j; k <= 9; k++) {
                    sum = (sum + dp[i - 1][k]) % 10_007;
                }
                dp[i][j] = sum;
            }
        }

        System.out.println(Arrays.stream(dp[n]).sum() % 10_007);

    }
}

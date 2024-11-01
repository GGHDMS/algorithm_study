package step;

import java.util.*;
import java.io.*;

public class Baek2293 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[] num;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n + 1][k + 1];

        Arrays.sort(num);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j > num[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - num[i]];
                } else if (j == num[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - num[i]] + 1;
                } else {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
        

    }

}

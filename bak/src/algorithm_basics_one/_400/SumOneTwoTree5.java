package algorithm_basics_one._400;

import java.io.*;

public class SumOneTwoTree5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final long mod = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[100_001][4];

        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
        }

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append((dp[k][1] + dp[k][2] + dp[k][3]) % mod).append("\n");
        }

        System.out.println(sb);
    }
}

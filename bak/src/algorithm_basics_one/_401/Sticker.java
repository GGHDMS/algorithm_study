package algorithm_basics_one._401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(br.readLine());
            int[][] p = new int[k + 1][2];
            int[][] dp = new int[k + 1][2];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 1; l <= k; l++) {
                    p[l][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] = p[1][0];
            dp[1][1] = p[1][1];

            int max = Math.max(dp[1][0], dp[1][1]);
            for (int j = 2; j <= k; j++) {
                dp[j][0] = Math.max(dp[j - 1][1] + p[j][0], dp[j - 2][1] + p[j][0]);
                max = Math.max(max, dp[j][0]);
                dp[j][1] = Math.max(dp[j - 1][0] + p[j][1], dp[j - 2][0] + p[j][1]);
                max = Math.max(max, dp[j][1]);
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

}

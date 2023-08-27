package algorithm_basics_one._401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGBStreet {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] p = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = p[0][0];
        dp[0][1] = p[0][1];
        dp[0][2] = p[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.min(dp[i - 1][1] + p[i][0], dp[i - 1][2] + p[i][0]);
            dp[i][1] = Integer.min(dp[i - 1][0] + p[i][1], dp[i - 1][2] + p[i][1]);
            dp[i][2] = Integer.min(dp[i - 1][0] + p[i][2], dp[i - 1][1] + p[i][2]);
        }

        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());
    }
}

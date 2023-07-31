package algorithm_basics_one._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int answer = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (p[j] < p[i] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1 ;
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}

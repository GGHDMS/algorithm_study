package algorithm_basics_one._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ContinuousSum {

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

        dp[0] = p[0];
        int max = p[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + p[i], p[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}

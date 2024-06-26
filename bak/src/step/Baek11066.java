import java.util.*;
import java.io.*;

public class Baek11066 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int[] array = new int[k + 1];
            int[][] dp = new int[k + 1][k + 1];
            int[] sum = new int[k + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= k; j++) {
                array[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + array[j];
            }

            for (int n = 1; n <= k; n++) {
                for (int from = 1; from + n <= k; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int devide = from; devide < to; devide++) {
                        dp[from][to] = Math.min(dp[from][to],
                                dp[from][devide] + dp[devide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(dp[1][k]);
        }
    }
}

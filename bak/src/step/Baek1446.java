import java.util.*;
import java.io.*;

public class Baek1446 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, d;

    static int[][] array;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        array = new int[n][3];
        dp = new int[d + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
            array[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < n; j++) {
                if (array[j][1] == i) {
                    dp[i] = Math.min(dp[array[j][0]] + array[j][2], dp[i]);
                }
            }
        }

        System.out.println(dp[d]);

    }
}

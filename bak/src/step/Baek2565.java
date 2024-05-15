import java.util.*;
import java.io.*;

public class Baek2565 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] array;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        array = new int[n][2];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (o1, o2) -> o1[0] - o2[0]);

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[i][1] > array[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }

        System.out.println(n - max);
    }
}

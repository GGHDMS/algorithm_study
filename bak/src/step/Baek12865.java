import java.util.*;
import java.io.*;

public class Baek12865 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] array;
    static int n, k;

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n + 1][2];
        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (array[i][0] > j) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - array[i][0]] + array[i][1]);
            }
        }

        System.out.println(dp[n][k]);
    }
}

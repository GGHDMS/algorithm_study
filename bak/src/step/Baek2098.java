import java.util.*;
import java.io.*;

public class Baek2098 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static int[][] dp;
    static final int INF = 987654321;
    static int bitMap;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        bitMap = (1 << n) - 1;

        map = new int[n][n];
        dp = new int[n][bitMap];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int cur, int visited) {

        if (visited == bitMap) {
            if (map[cur][0] == 0) {
                return INF;
            }
            return map[cur][0];
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }
        dp[cur][visited] = INF;

        for (int i = 0; i < n; i++) {
            int point = 1 << i;

            if (map[cur][i] == 0 || (visited & point) != 0) {
                continue;
            }

            dp[cur][visited] = Math.min(dp[cur][visited], tsp(i, visited | point) + map[cur][i]);
        }
        return dp[cur][visited];
    }
}

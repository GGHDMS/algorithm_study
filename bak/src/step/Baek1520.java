import java.util.*;
import java.io.*;

public class Baek1520 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int m, n;
    static int[][] map;
    static int[][] dp;

    static int[][] direct = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int cY, int cX) {
        if (cY == m - 1 && cX == n - 1) {
            return 1;
        }

        if (dp[cY][cX] != -1) {
            return dp[cY][cX];
        }

        dp[cY][cX] = 0;

        for (int i = 0; i < 4; i++) {
            int nY = cY + direct[i][0];
            int nX = cX + direct[i][1];

            if (nY < 0 || nY >= m || nX < 0 || nX >= n) {
                continue;
            }

            if (map[cY][cX] <= map[nY][nX]) {
                continue;
            }

            dp[cY][cX] += dfs(nY, nX);
        }

        return dp[cY][cX];
    }
}

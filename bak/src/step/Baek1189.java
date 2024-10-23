import java.util.*;
import java.io.*;

public class Baek1189 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int r, c, k;
    static int answer = 0;

    static char[][] map;
    static boolean[][] visited;

    static int[][] direct = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {

            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int i, int j, int temp) {
        if (i == 0 && j == c - 1) {
            if (temp == k) {
                answer++;
            }

            return;
        }

        for (int a = 0; a < 4; a++) {
            int ni = i + direct[a][0];
            int nj = j + direct[a][1];

            if (ni < 0 || ni >= r || nj < 0 || nj >= c || visited[ni][nj] || map[ni][nj] == 'T') {
                continue;
            }

            visited[ni][nj] = true;
            dfs(ni, nj, temp + 1);
            visited[ni][nj] = false;
        }

    }
}

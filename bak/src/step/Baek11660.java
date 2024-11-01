package step;

import java.util.*;
import java.io.*;

public class Baek11660 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int[][] sum;
    static int n, m;
    static int[][] arr;
    static int x1, y1, x2, y2;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m][4];

        map = new int[n + 1][n + 1];
        sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + map[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(sum[i][j] + " ");
            }

            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x1 = arr[i][0];
            int y1 = arr[i][1];
            int x2 = arr[i][2];
            int y2 = arr[i][3];

            int temp = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            sb.append(temp).append("\n");
        }

        System.out.println(sb);

    }
}

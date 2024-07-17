import java.io.*;
import java.util.*;

public class Baek1080 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] before;
    static int[][] after;

    static int n, m;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        before = new int[n][m];
        after = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                before[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                after[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {

                if (before[i][j] == after[i][j]) {
                    continue;
                }

                change(i, j);
                answer++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    System.out.println(-1);
                    return;

                }

            }
        }

        System.out.println(answer);
    }

    static void change(int i, int j) {
        for (int a = i; a < i + 3; a++) {
            for (int b = j; b < j + 3; b++) {
                if (before[a][b] == 0) {
                    before[a][b] = 1;
                } else {
                    before[a][b] = 0;
                }
            }
        }
    }
}
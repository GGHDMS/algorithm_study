import java.util.*;
import java.io.*;

public class Baek14502 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[][] map;

    static int[][] go = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        build(0, 0, 0);

        System.out.println(answer);

    }

    static void build(int s, int e, int temp) {
        if (temp == 3) {
            fill();
            return;
        }

        for (int i = s; i < n; i++) {
            for (int j = (i == s ? e : 0); j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    build(i, j + 1, temp + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void fill() {
        int[][] tempMap = new int[n][m];
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 2) {
                    deque.push(new int[] { i, j });
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(tempMap[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println();

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] now = deque.poll();
                for (int j = 0; j < 4; j++) {
                    int nextY = now[0] + go[j][0];
                    int nextX = now[1] + go[j][1];

                    if (nextY < 0 || nextY >= n) {
                        continue;
                    }

                    if (nextX < 0 || nextX >= m) {
                        continue;
                    }

                    if (tempMap[nextY][nextX] == 0) {
                        tempMap[nextY][nextX] = 2;
                        deque.push(new int[] { nextY, nextX });
                    }
                }
            }
        }

        int answerTemp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    answerTemp++;
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(tempMap[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println();

        answer = Math.max(answer, answerTemp);
    }
}

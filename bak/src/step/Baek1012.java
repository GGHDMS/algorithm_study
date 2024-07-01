import java.util.*;
import java.io.*;

public class Baek1012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t;
    static int[][] direct = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());

        for (int temp = 0; temp < t; temp++) {
            st = new StringTokenizer(br.readLine());

            int m, n, k;
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[b][a] = 1;
            }

            System.out.println(union(map, visited, m, n));

        }
    }

    static int union(int[][] map, boolean[][] visited, int m, int n) {
        int value = 0;
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    value++;
                    visited[i][j] = true;
                    deque.add(new int[] { i, j });

                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        for (int a = 0; a < size; a++) {
                            int[] c = deque.poll();
                            for (int b = 0; b < 4; b++) {
                                int cI = c[0] + direct[b][0];
                                int cJ = c[1] + direct[b][1];

                                if (0 > cI || cI >= n) {
                                    continue;
                                }

                                if (0 > cJ || cJ >= m) {
                                    continue;
                                }

                                if (map[cI][cJ] == 1 && !visited[cI][cJ]) {
                                    visited[cI][cJ] = true;
                                    deque.add(new int[] { cI, cJ });
                                }
                            }
                        }

                    }

                }

            }
        }

        return value;
    }
}

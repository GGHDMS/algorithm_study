package bak.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bak16234 {

    static int[] x = new int[]{1, 0, -1, 0};
    static int[] y = new int[]{0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, L, R;
    static int[][] map;
    static int answer = 0;


    public static void main(String[] args) throws Exception {
        init();

        while (true) {
            int[][] check = new int[N][N];

            int checkNum = openBorder(check);
            if (checkNum == N * N) {
                break;
            }

            move(checkNum, check);
            answer++;
        }

        System.out.println(answer);

    }

    public static int openBorder(int[][] check) {
        int checkNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j] == 0) {
                    checkNum++;
                    bfs(i, j, check, checkNum);
                }
            }
        }

        return checkNum;
    }

    public static void move(int checkNum, int[][] check) {
        int[] count = new int[checkNum + 1];
        int[] sum = new int[checkNum + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count[check[i][j]]++;
                sum[check[i][j]] += map[i][j];
            }
        }

        for (int i = 1; i <= checkNum; i++) {
            sum[i] = sum[i] / count[i];
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sum[check[i][j]];
            }
        }
    }


    public static void bfs(int i, int j, int[][] check, int checkNum) {
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{i, j});
        check[i][j] = checkNum;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int k = 0; k < size; k++) {
                int[] current = deque.remove();
                for (int l = 0; l < 4; l++) {
                    int ci = current[0] + y[l];
                    int cj = current[1] + x[l];
                    if (0 > ci || ci >= N) {
                        continue;
                    }
                    if (0 > cj || cj >= N) {
                        continue;
                    }
                    if (check[ci][cj] != 0) {
                        continue;
                    }
                    int abs = Math.abs(map[current[0]][current[1]] - map[ci][cj]);

                    if (L <= abs && abs <= R) {
                        check[ci][cj] = checkNum;
                        deque.add(new int[]{ci, cj});
                    }
                }
            }
        }
    }


    public static void init() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}



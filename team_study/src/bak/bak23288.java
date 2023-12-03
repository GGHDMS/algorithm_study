package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bak23288 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int[] current = {1, 1};

    static int n, m, k;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int direct = 0;
    static int score = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 0; a < k; a++) {
            rollDice();
            score += map[current[0]][current[1]] * bfs();
            int bottom = dice[5];
            nextDirect(bottom);

//            System.out.println(bottom + " " + current[0] + " " + current[1]);
        }
        System.out.println(score);
    }

    public static int bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] check = new int[n + 1][m + 1];
        int value = 0;

        deque.add(current);
        int currentValue = map[current[0]][current[1]];
        check[current[0]][current[1]] = 1;
        value++;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] remove = deque.remove();
                for (int j = 0; j < 4; j++) {
                    int _x = remove[1] + x[j];
                    int _y = remove[0] + y[j];

                    if (1 > _x || _x > m) {
                        continue;
                    }

                    if (1 > _y || _y > n) {
                        continue;
                    }

                    if (map[_y][_x] == currentValue && check[_y][_x] == 0) {
                        deque.add(new int[]{_y, _x});
                        value++;
                        check[_y][_x] = 1;
                    }
                }
            }
        }
        return value;
    }


    public static void rollDice() {
        if (direct == 0) {
            if (current[1] == m) {
                direct = 2;
            }
        } else if (direct == 1) {
            if (current[0] == n) {
                direct = 3;
            }
        } else if (direct == 2) {
            if (current[1] == 1) {
                direct = 0;
            }
        } else if (direct == 3) {
            if (current[0] == 1) {
                direct = 1;
            }
        }

        switch (direct) {
            case 0:
                toEast();
                current[1]++;
                break;
            case 1:
                toSouth();
                current[0]++;
                break;
            case 2:
                toWest();
                current[1]--;
                break;
            case 3:
                toNorth();
                current[0]--;
                break;
        }
    }

    public static void nextDirect(int bottom) {
        int value = map[current[0]][current[1]];
        if (bottom > value) {
            direct = (direct + 1) % 4;
        } else if (bottom < value) {
            direct = direct - 1;
            if (direct == -1) {
                direct = 3;
            }
        }
    }

    public static void toEast() {
        int temp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[2];
        dice[2] = temp;
    }

    public static void toWest() {
        int temp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[3];
        dice[3] = temp;
    }

    public static void toNorth() {
        int temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[5];
        dice[5] = dice[1];
        dice[1] = temp;
    }

    public static void toSouth() {
        int temp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[4];
        dice[4] = temp;
    }


}

package bak.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek3190 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};
    static int[] point = {1, 1};
    static int go = 0;
    static boolean can = true;
    static int snakeLength = 1;

    static int[][] map;
    static int[][] directionMap;

    static int[] time;
    static int timePoint = 0;

    static char[] direct;
    static int n, k;
    static int l;

    public static void main(String[] args) throws Exception {
        init();

        int currentTime = 0;
        while (true) {
            currentTime++;
            move();
            if (!can) {
                break;
            }
            snake();
            if (timePoint < l) {
                changeDirect(currentTime);
            }
        }

        System.out.println(currentTime);
    }

    static void move() {
        point[0] = point[0] + y[go];
        point[1] = point[1] + x[go];

        if (point[0] < 1 || n < point[0]) {
            can = false;
            return;
        }

        if (point[1] < 1 || n < point[1]) {
            can = false;
            return;
        }

        if (map[point[0]][point[1]] == 3 || map[point[0]][point[1]] == 1) {
            can = false;
            return;
        }

        map[point[0]][point[1]] += 1;
        directionMap[point[0]][point[1]] = go;
    }

    static void snake() {
        if (map[point[0]][point[1]] != 3) {
            tailRemove();
        } else {
            snakeLength++;
        }
    }

    static void tailRemove() {
        int i = 0;
        int iy = point[0];
        int ix = point[1];
        int prevY = iy;
        int prevX = ix;

        while (i < snakeLength) {
            switch (directionMap[iy][ix]) {
                case 0:
                    prevX = ix - 1;
                    break;
                case 1:
                    prevY = iy - 1;
                    break;
                case 2:
                    prevX = ix + 1;
                    break;
                case 3:
                    prevY = iy + 1;
                    break;
            }

            if (directionMap[prevY][prevX] == -1) {
                break;
            }

            ix = prevX;
            iy = prevY;
            i++;
        }

        map[iy][ix] = 0;
        directionMap[iy][ix] = -1;
    }


    static void changeDirect(int currentTime) {
        if (currentTime == time[timePoint]) {
            char c = direct[timePoint];

            if (c == 'L') {
                go = go - 1;
                if (go == -1) {
                    go = 3;
                }
            } else {
                go = go + 1;
                go %= 4;
            }
            timePoint++;
        }

    }


    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        directionMap = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                directionMap[i][j] = -1;
            }
        }

        map[1][1] = 1;
        directionMap[1][1] = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 2;
        }

        l = Integer.parseInt(br.readLine());
        time = new int[l];
        direct = new char[l];

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            direct[i] = st.nextToken().charAt(0);
        }
    }
}

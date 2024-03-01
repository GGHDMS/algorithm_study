
import java.io.*;
import java.util.*;

public class Baek2630 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int n;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        devide(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void devide(int i, int j, int k) {
        boolean[] check = new boolean[2];

        for (int ci = i; ci < i + k; ci++) {
            for (int cj = j; cj < j + k; cj++) {
                if (map[ci][cj] == 0) {
                    check[0] = true;
                } else {
                    check[1] = true;
                }
                if (check[0] && check[1]) {
                    int temp =  k / 2;
                    devide(i, j, temp);
                    devide(i + temp, j, temp);
                    devide(i, j + temp, temp);
                    devide(i + temp, j + temp, temp);
                    return;
                }
            }
        }

        if (check[0]) {
            white++;
        } else {
            blue++;
        }
    }
}
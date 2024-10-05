import java.util.*;
import java.io.*;

public class Baek1913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, target;
    static int[][] map;
    static int[][] dict = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        target = Integer.parseInt(br.readLine());

        int temp = n * n;
        int a = 0;
        int b = 0;
        int op = 0;
        int[] point = new int[2];

        for (int i = 0; i < n * n; i++) {
            if (target == temp) {
                point[0] = a + 1;
                point[1] = b + 1;
            }

            map[a][b] = temp--;

            int nextA = a + dict[op][0];
            int nextB = b + dict[op][1];

            if (0 <= nextA && nextA < n && 0 <= nextB && nextB < n) {
                if (map[nextA][nextB] == 0) {
                    a = nextA;
                    b = nextB;
                    continue;
                }
            }

            op = (op + 1) % 4;

            a = a + dict[op][0];
            b = b + dict[op][1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(point[0] + " " + point[1]);
    }

}

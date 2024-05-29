import java.util.*;
import java.io.*;

public class Back1992 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {

            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        System.out.println(devideAndConquer(0, 0, n));
    }

    static String devideAndConquer(int y, int x, int size) {
        boolean zero = false;
        boolean one = false;

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] == '0') {
                    zero = true;
                } else {
                    one = true;
                }

                if (zero && one) {
                    int nextY = y + size / 2;
                    int nextX = x + size / 2;
                    int nextS = size / 2;

                    return "(" + devideAndConquer(y, x, nextS)
                            + devideAndConquer(y, nextX, nextS)
                            + devideAndConquer(nextY, x, nextS)
                            + devideAndConquer(nextY, nextX, nextS)
                            + ")";
                }
            }
        }

        if (zero) {
            return "0";
        } else {
            return "1";
        }
    }
}

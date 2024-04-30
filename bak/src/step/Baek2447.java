import java.io.*;

public class Baek2447 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static char[][] basic = { { '*', '*', '*' }, { '*', ' ', '*' }, { '*', '*', '*' } };
    static char[][] map;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = ' ';
            }
        }

        recur(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j]);
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }

    public static void recur(int y, int x, int len) {
        if (len == 3) {
            int a = 0;
            for (int i = y; i < y + 3; i++) {
                int b = 0;
                for (int j = x; j < x + 3; j++) {
                    map[i][j] = basic[a][b++];
                }
                a++;
            }
            return;
        }

        int nextLen = len / 3;

        for (int i = y; i < y + len; i += nextLen) {
            for (int j = x; j < x + len; j += nextLen) {
                if (i == y + nextLen && j == x + nextLen) {
                    continue;
                }

                recur(i, j, nextLen);
            }
        }

    }
}

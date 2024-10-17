import java.util.*;
import java.io.*;

public class Baek1074 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, r, c;

    static boolean finish = false;
    static int len;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        len = (int) Math.pow(2, n);

        dfs(0, 0, 0, len);
    }

    public static void dfs(int t, int i, int j, int s) {
        if (finish) {
            return;
        }

        if (s == 2) {
            int temp = t;
            for (int a = i; a <= i + 1; a++) {
                for (int b = j; b <= j + 1; b++) {
                    if (a == r && b == c) {
                        System.out.println(temp);
                        finish = true;
                    }
                    temp++;
                }
            }
            return;
        }

        int nt = s * s / 4;
        int ns = s / 2;

        if (r < i + ns) {
            if (c < j + ns) {
                dfs(t, i, j, ns);

            } else {

                dfs(t + nt, i, j + ns, ns);
            }
        } else {
            if (c < j + ns) {
                dfs(t + nt * 2, i + ns, j, ns);
            } else {
                dfs(t + nt * 3, i + ns, j + ns, ns);
            }
        }
    }
}

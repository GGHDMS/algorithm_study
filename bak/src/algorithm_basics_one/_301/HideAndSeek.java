package algorithm_basics_one._301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HideAndSeek {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int gcd = 0;

        st = new StringTokenizer(br.readLine());
        if (n == 1) {
            System.out.println(Math.abs(s - Integer.parseInt(st.nextToken())));
        } else {
            gcd = Math.abs(s - Integer.parseInt(st.nextToken()));
            for (int i = 1; i < n; i++) {
                int b = Math.abs(s - Integer.parseInt(st.nextToken()));
                if (gcd > b) {
                    gcd = gcd(gcd, b);
                } else {
                    gcd = gcd(b, gcd);
                }
            }
            System.out.println(gcd);
        }
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}

package algorithm_basics_one._300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeastCommonMultiple {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd;
            if (a > b) {
                gcd = g(a, b);
            } else {
                gcd = g(b, a);
            }

            sb.append(a * b / gcd).append("\n");
        }

        System.out.println(sb);
    }

    public static int g(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return g(b, a % b);
        }
    }
}

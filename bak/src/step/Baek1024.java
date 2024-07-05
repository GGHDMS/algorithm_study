import java.util.*;
import java.io.*;

public class Baek1024 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long l = Integer.parseInt(st.nextToken());

        while (true) {
            long min = n / l - ((l - 1) / 2);

            if (min < 0 || l > 100) {
                System.out.println(-1);
                return;
            }

            long sum = (min * 2 + l - 1) * l / 2;

            if (sum == n) {
                for (int i = 0; i < l; i++) {
                    System.out.print((min + i) + " ");
                }
                return;
            }
            l++;
        }

    }

}

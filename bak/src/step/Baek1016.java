import java.util.*;
import java.io.*;

public class Baek1016 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[] arr = new boolean[1_000_001];
    static boolean[] check = new boolean[1_000_001];
    static long min, max;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        int n = (int) Math.sqrt(arr.length);

        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == false) {
                int s = i * i;
                for (int j = s; j <= 1000000; j += i) {
                    arr[j] = true;
                }
            }
        }

        int t = (int) Math.sqrt(max);

        for (int i = 2; i <= t; i++) {
            if (arr[i]) {
                continue;
            }

            long pow = (long) i * i;
            long tmp = (long) Math.ceil((double) min / pow);

            for (long j = tmp; j * pow <= max; j++) {
                check[(int) (j * pow - min)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}

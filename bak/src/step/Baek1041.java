import java.util.*;
import java.io.*;

public class Baek1041 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long[] array = new long[6];
    static long one = Long.MAX_VALUE;
    static long two = Long.MAX_VALUE;
    static long three = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long max = 0;
        long sum = 0;
        for (int i = 0; i < 6; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            sum += array[i];
            max = Math.max(max, array[i]);
        }

        if (n == 1) {
            System.out.println(sum - max);
            return;
        }

        for (int i = 0; i < 6; i++) {
            one = Math.min(one, array[i]);

            for (int j = 0; j < 6; j++) {
                if (i == j) {
                    continue;
                }
                if (i + j == 5) {
                    continue;
                }
                two = Math.min(two, array[i] + array[j]);

                for (int k = 0; k < 6; k++) {
                    if (i == k || k == j) {
                        continue;
                    }

                    if (i + k == 5 || j + k == 5) {
                        continue;
                    }
                    three = Math.min(three, array[i] + array[j] + array[k]);
                }
            }
        }
        long answer = 4L * three + (n - 2L) * 8L * two + 4L * two + (n - 2L) * (n - 2L) * 5L * one
                + (n - 2L) * 4L * one;
        System.out.println(answer);
    }

}

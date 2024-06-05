import java.io.*;
import java.util.*;

public class Baek1654 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int k, n;

    static long min = 0, max = 0;
    static long[] array;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        array = new long[k];

        for (int i = 0; i < k; i++) {
            array[i] = Integer.parseInt(br.readLine());
            if (max < array[i]) {
                max = array[i];
            }
        }

        max++;
        while (min < max) {
            long mid = (max + min) / 2;
            long count = 0;

            for (int i = 0; i < k; i++) {
                count += array[i] / mid;
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(min - 1);
    }
}

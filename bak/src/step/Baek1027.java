import java.util.*;
import java.io.*;

public class Baek1027 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] array;
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int max = 0;

        array = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (j > i) {
                    if (canView(i, j)) {
                        sum++;
                    }
                } else {
                    if (canView(j, i)) {
                        sum++;
                    }
                }

            }
            max = Math.max(sum, max);
        }

        System.out.println(max);

    }

    static boolean canView(int i, int j) {
        double a = (array[j] - array[i]) / ((double)j - i);

        for (int k = i + 1; k < j; k++) {
            if (a * (k - i) + array[i] <= array[k]) {
                return false;
            }
        }

        return true;
    }
}

import java.util.*;
import java.io.*;

public class Baek1052 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static int[] array = new int[20_000_001];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int max = 1;
        int current = n;
        array[1] = n;

        int answer = 0;
        while (current > k) {
            boolean changed = false;
            for (int i = 1; i <= max; i = i * 2) {
                if (array[i] < 2) {
                    continue;
                }
                changed = true;
                int num = array[i] / 2;
                array[i] = array[i] % 2;
                array[i * 2] += num;
                max = Math.max(i * 2, max);
                current -= num;
            }
            if (!changed) {
                array[1]++;
                answer++;
                current++;
            }
        }
        System.out.println(answer);
    }
}

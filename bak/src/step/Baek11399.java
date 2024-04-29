import java.io.*;
import java.util.*;

public class Baek11399 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        array = new int[n + 1];
        dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + array[i];
            sum += dp[i];
        }

        System.out.println(sum);

    }
}

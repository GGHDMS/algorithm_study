import java.io.*;

public class Baek2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dp;
    static int[] array;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        array = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(array[1]);
            return;
        } else if (n == 2) {
            System.out.println(array[1] + array[2]);
            return;
        }

        dp[1] = array[1];
        dp[2] = array[1] + array[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + array[i - 1] + array[i], dp[i - 2] + array[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        
        System.out.println(dp[n]);
    }
}

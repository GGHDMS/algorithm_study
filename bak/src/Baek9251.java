import java.io.*;

public class Baek9251 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] dp;
    static String a, b;
    static int n, m;

    public static void main(String[] args) throws Exception {
        a = br.readLine();
        b = br.readLine();
        n = a.length();
        m = b.length();


        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}

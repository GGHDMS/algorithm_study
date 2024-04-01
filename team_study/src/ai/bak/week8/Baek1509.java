package ai.bak.week8;

import java.io.*;

public class Baek1509 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean palindrome[][];
    static int[] dp;
    static String s;

    public static void main(String[] args) throws Exception {
        s = br.readLine();
        palindrome = new boolean[s.length() + 1][s.length() + 1];
        dp = new int[s.length() + 1];

        feelPalidrome();

        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = i; j > 0; j--) {
                if (!palindrome[j][i]) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[j - 1] + 1);
            }
        }

        System.out.println(dp[s.length()]);
    }

    public static void feelPalidrome() {
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                palindrome[i][j] = checkPalindrom(i, j);
            }
        }
    }

    public static boolean checkPalindrom(int i, int j) {
        int len = j - i;

        if (len == 0) {
            return true;
        } else if (len == 1) {
            return s.charAt(i - 1) == s.charAt(j - 1);
        }

        while (i <= j) {
            if (s.charAt(i - 1) != s.charAt(j - 1)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}

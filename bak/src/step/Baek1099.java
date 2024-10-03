import java.io.*;
import java.util.*;

public class Baek1099 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String target;
    static int dp[];
    static int n;
    static String[] word;
    static String[] sortedWord;

    public static void main(String[] args) throws Exception {

        target = br.readLine();
        n = Integer.parseInt(br.readLine());

        dp = new int[target.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        word = new String[n];
        sortedWord = new String[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            word[i] = s;
            char[] c = s.toCharArray();
            Arrays.sort(c);
            sortedWord[i] = new String(c);
        }

        for (int i = 1; i <= target.length(); i++) {
            for (int j = 0; j < n; j++) {
                int len = i - word[j].length();
                if (len < 0 || dp[len] < 0) {
                    continue;
                }

                String s = target.substring(len, i);

                char[] c = s.toCharArray();
                Arrays.sort(c);

                if (!new String(c).equals(sortedWord[j])) {
                    continue;
                }

                int temp = 0;

                for (int k = 0; k < word[j].length(); k++) {
                    if (word[j].charAt(k) != s.charAt(k)) {
                        temp++;
                    }
                }

                if (dp[i] == -1) {
                    dp[i] = dp[i - word[j].length()] + temp;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - word[j].length()] + temp);
                }
            }
        }

        System.out.println(dp[target.length()]);
    }
}

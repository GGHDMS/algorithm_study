import java.util.*;
import java.io.*;

public class Beak11054 {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] list;
    static int[] dp1;
    static int[] dp2;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int answer = 0;

        list = new int[n];
        dp1 = new int[n];
        dp2 = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 && list[i] <= list[0] && dp1[i] == 0) {
                    dp1[i] = 1;
                } else if (list[i] > list[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == n - 1 && list[i] <= list[n - 1] && dp2[i] == 0) {
                    dp2[i] = 1;
                } else if (list[i] > list[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }

            answer = Math.max(answer, dp1[i] + dp2[i] - 1);
        }

        /*
        for (int i : dp1) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : dp2) {
            System.out.print(i + " ");
        }
        System.out.println();
        */

        System.out.println(answer);
    }
}

import java.util.*;
import java.io.*;

public class Baek1082 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[] cost;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        cost = new int[n];
        st = new StringTokenizer(br.readLine());
        int min = 50;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            if (cost[i] <= min) {
                min = cost[i];
                minIndex = i;
            }
        }
        m = Integer.parseInt(br.readLine());

        String s = "";
        if (cost[0] >= cost[minIndex]) {
            while (m - cost[minIndex] >= 0) {
                s = s + minIndex;
                m -= cost[minIndex];
            }
        } else {
            if (m - cost[minIndex] >= 0) {
                s = s + minIndex;
                m -= cost[minIndex];
            }
            while (m - cost[0] >= 0) {
                s = s + "0";
                m -= cost[0];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int t = s.charAt(i) - '0';
            int iCost = cost[t];

            for (int j = n - 1; j > t; j--) {
                if (iCost + m - cost[j] >= 0) {
                    s = s.substring(0, i) + j + s.substring(i + 1);
                    m = iCost + m - cost[j];
                    break;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0'){
                System.out.println(s);
                return;
            }
        }

        System.out.println(0);
    }
}

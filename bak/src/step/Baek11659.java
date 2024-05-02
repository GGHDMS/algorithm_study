import java.util.*;
import java.io.*;

public class Baek11659 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] array;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());       

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n + 1];
        sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + array[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(sum[b] - sum[a - 1]);
        }

    }

}

import java.util.*;
import java.io.*;

public class Baek9372 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t, n, m;

    public static void main(String[] args) throws Exception {

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                br.readLine();
            }

            System.out.println(n -1);
        }

    }
}

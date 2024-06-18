import java.io.*;
import java.util.*;

public class Baek10816 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int k = map.getOrDefault(temp, 0);
            map.put(temp, k + 1);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(temp, 0)).append(" ");
        }

        System.out.println(sb);

    }
}

import java.util.*;
import java.io.*;

public class Baek1620 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static Map<Integer, String> index = new HashMap<>();
    static Map<String, Integer> name = new HashMap<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            index.put(i, s);
            name.put(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if ('0' <= s.charAt(0) && s.charAt(0) <= '9') {
                sb.append(index.get(Integer.valueOf(s))).append("\n");
            } else {
                sb.append(name.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }
}

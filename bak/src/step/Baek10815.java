import java.util.*;
import java.io.*;

public class Baek10815 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static Set<Integer> s = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            if(s.contains(Integer.parseInt(st.nextToken()))){
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}

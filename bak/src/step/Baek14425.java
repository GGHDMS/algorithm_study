import java.io.*;
import java.util.*;

public class Baek14425 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> set = new HashSet<>();

    static int n, m;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int answer = 0;

        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}

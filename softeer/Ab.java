package softeer;

import java.util.*;
import java.io.*;

public class Ab {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int k = i+1;
            int m = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append("Case " + "#" + k + " ")
                    .append(m).append("\n");
        }

        System.out.println(sb);

    }
}

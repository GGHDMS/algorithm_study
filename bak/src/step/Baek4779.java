import java.io.*;
import java.util.*;

public class Baek4779 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String s;
        StringBuilder answer = new StringBuilder();

        while ((s = br.readLine()) != null) {
            int i = Integer.parseInt(s);
            int n = (int) Math.pow(3, i);
            char[] c = new char[n];
            Arrays.fill(c, '-');

            recur(c, 0, n);
            for (char j : c) {
                answer.append(j);
            }
            answer.append('\n');
        }

        System.out.println(answer);
    }

    public static void recur(char[] c, int start, int end) {
        int s = (end - start) / 3;
        if (s == 0) {
            return;
        }

        for (int i = start + s; i < end - s; i++) {
            c[i] = ' ';
        }

        recur(c, start, start + s);
        recur(c, start + 2 * s, end);
    }

}

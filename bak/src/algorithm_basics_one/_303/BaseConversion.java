package algorithm_basics_one._303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaseConversion {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int num = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(st.nextToken());
            num += k * Math.pow(a, n - i);
        }

        while (num != 0) {
            deque.addLast(num % b);
            num /= b;
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}

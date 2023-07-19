package algorithm_basics_one._201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class RightBigNumber {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Deque<Point> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n + 1];
        Arrays.fill(answer, -1);

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekLast().num < num) {
                answer[deque.pollLast().idx] = num;
            }
            deque.addLast(new Point(i, num));
        }

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static class Point {
        int idx;
        int num;

        public Point(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

}

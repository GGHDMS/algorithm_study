package algorithm_basics_one._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] p = new int[n];
        Point[] dp = new Point[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        Point answer = new Point(0, 1);
        int answer_idx = 0;
        dp[0] = answer;

        for (int i = 1; i < n; i++) {
            Point idx_max = new Point(i, 0);
            for (int j = i - 1; j >= 0; j--) {
                if (p[i] > p[j] && idx_max.num < dp[j].num) {
                    idx_max = new Point(j, dp[j].num);
                }
            }
            dp[i] = new Point(idx_max.idx, idx_max.num + 1);
            if (answer.num < dp[i].num) {
                answer = dp[i];
                answer_idx = i;
            }
        }

        deque.addLast(p[answer_idx]);

        System.out.println(answer.num);
        for (int i = answer.num - 1; i > 0; i--) {
            deque.addLast(p[answer.idx]);
            answer = dp[answer.idx];
        }


        while (!deque.isEmpty()) {
            System.out.print(deque.pollLast() + " ");
        }
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

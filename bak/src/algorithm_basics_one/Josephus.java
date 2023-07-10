package algorithm_basics_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Josephus {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        builder.append("<");

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() !=1) {
            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    builder.append(queue.poll()).append(", ");
                } else {
                    queue.offer(queue.poll());
                }
            }
        }
        builder.append(queue.pop()).append(">");

        System.out.println(builder);
    }
}

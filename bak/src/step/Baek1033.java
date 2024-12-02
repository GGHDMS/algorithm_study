import java.util.*;
import java.io.*;

public class Baek1033 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] answer;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            c *= answer[b];
            d *= answer[a];

            boolean[] visited = new boolean[n];
            bfs(answer, visited, a, c);
            bfs(answer, visited, b, d);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int s = answer[0];

        for (int i = 1; i < n; i++) {
            s = getM(s, answer[i]);
        }

        for (int i = 0; i < n; i++) {
            answer[i] /= s;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

    static void bfs(int[] answer, boolean[] visited, int i, int j) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(i);
        visited[i] = true;

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            answer[cur] *= j;
            for (int k : graph.get(cur)) {
                if (visited[k]) {
                    continue;
                }

                deque.add(k);
                visited[k] = true;
            }

        }
    }

    static int getL(int a, int b) {
        int m = getM(a, b);
        return (a * b) / m;
    }

    static int getM(int a, int b) {
        while (a % b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }

        return b;
    }

}

import java.util.*;
import java.io.*;

public class Baek1058 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> graph = new ArrayList<>();

    static int n;
    static boolean[] visited;
    static int temp;

    static int answer;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'Y') {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];

            temp = 0;
            bfs(i);
            answer = Math.max(temp, answer);
        }

        System.out.println(answer - 1);

    }

    static void bfs(int p) {
        Deque<Integer> deque = new ArrayDeque<>();

        visited[p] = true;
        temp++;
        deque.add(p);
        int s = 0;
        while (!deque.isEmpty() && s != 2) {
            int t = deque.size();

            for (int i = 0; i < t; i++) {
                int k = deque.poll();
                for (int j : graph.get(k)) {
                    if (visited[j]) {
                        continue;
                    }

                    temp++;
                    deque.add(j);
                    visited[j] = true;
                }
            }
            s++;

        }
    }
}

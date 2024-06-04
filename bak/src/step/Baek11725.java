import java.util.*;
import java.io.*;

public class Baek11725 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static ArrayList<Integer>[] graph;
    static Deque<Integer> deque = new ArrayDeque<>();
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs() {
        visited[1] = true;
        for (int i : graph[1]) {
            deque.add(i);
            parent[i] = 1;
        }

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int p = deque.remove();
                visited[p] = true;
                for (int j : graph[p]) {
                    if (!visited[j]) {
                        parent[j] = p;
                        deque.add(j);
                    }
                }
            }
        }
    }
}

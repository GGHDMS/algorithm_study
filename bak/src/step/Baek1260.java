import java.util.*;
import java.io.*;

public class Baek1260 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, v;

    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        dfsVisited = new boolean[n + 1];
        bfsVisited = new boolean[n + 1];

        dfs(v);
        bfs(v);

        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

    static void dfs(int c) {
        if (dfsVisited[c]) {
            return;
        }

        dfsSb.append(c + " ");
        dfsVisited[c] = true;

        List<Integer> list = graph.get(c);

        for (int i : list) {
            dfs(i);
        }
    }

    static void bfs(int c) {
        Deque<Integer> deque = new ArrayDeque<>();

        bfsVisited[c] = true;
        deque.add(c);

        while (deque.size() != 0) {

            int cSize = deque.size();

            for (int i = 0; i < cSize; i++) {
                int current = deque.poll();
                bfsSb.append(current + " ");
                List<Integer> list = graph.get(current);

                for(int j : list){
                    if(!bfsVisited[j]){
                        deque.add(j);
                        bfsVisited[j] = true;
                    }
                }

            }

        }
    }
}
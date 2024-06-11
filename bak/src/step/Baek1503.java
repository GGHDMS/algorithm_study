import java.util.*;
import java.io.*;

public class Baek1503 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, e;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[n + 1];

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        // 1 > n1, n2 -> n
        int res1 = 0;
        res1 += dijkstra(1, n1);
        res1 += dijkstra(n1, n2);
        res1 += dijkstra(n2, n);

        // 1 > n2, n1 -> n
        int res2 = 0;
        res2 += dijkstra(1, n2);
        res2 += dijkstra(n2, n1);
        res2 += dijkstra(n1, n);

        int ans = Math.min(res1, res2);

        if(ans >= 200_000_000){
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(visited, 200_000_000);

        pq.offer(new Edge(start, 0));
        visited[start] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int nowV = e.v;
            int nowW = e.w;

            if (nowW > visited[nowV]) {
                continue;
            }

            List<Edge> list = graph.get(e.v);

            for (Edge ob : list) {
                if(visited[ob.v] > nowW + ob.w){
                    visited[ob.v] = nowW + ob.w;
                    pq.offer(new Edge(ob.v, visited[ob.v]));
                }
            }
        }
        return visited[end];
    }

    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}

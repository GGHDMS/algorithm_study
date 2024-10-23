import java.io.*;
import java.util.*;

public class Baek1197 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<List<int[]>> graph = new ArrayList<>();
    static int v, e;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    static boolean[] visited;

    static int answer = 0;
    static int temp = 0;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[] { b, c });
            graph.get(b).add(new int[] { a, c });
        }

        visited[1] = true;
        for (int[] i : graph.get(1)) {
            pq.add(i);
        }

        while (temp != v - 1) {
            int[] i = pq.poll();

            if (visited[i[0]]) {
                continue;
            }

            visited[i[0]] = true;
            answer += i[1];
            temp++;
            for (int[] j : graph.get(i[0])) {
                pq.add(j);
            }
        }

        System.out.println(answer);
    }

}

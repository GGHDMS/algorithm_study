import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
    static int[] check;
    static List<ArrayList<Edge>> arrayLists;

    static int a, b;
    public static int solution(List<ArrayList<Edge>> arrayLists) {
        int answer = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        queue.offer(new Edge(1, 0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (check[edge.vex] == 1) {
                continue;
            }
            check[edge.vex] = 1;
            answer += edge.cost;

            ArrayList<Edge> edges = arrayLists.get(edge.vex);
            for (Edge e : edges) {
                if (check[e.vex] == 1) {
                    continue;
                }
                queue.offer(e);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        check = new int[a + 10];

        arrayLists = new ArrayList<>();
        for (int i = 0; i <= a; i++) {
            arrayLists.add(new ArrayList<>());
        }
        for (int i = 0; i < b; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int cost = scanner.nextInt();
            arrayLists.get(v1).add(new Edge(v2, cost));
            arrayLists.get(v2).add(new Edge(v1, cost));
        }

        System.out.println(solution(arrayLists));

    }

    public static class Edge implements Comparable<Edge> {
        public int vex;
        public int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}

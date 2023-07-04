import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Kruskal {
    public static int[] check;
    public static List<Edge> edges;
    static int v;
    static int e;

    public static int find(int v) {
        if (check[v] == v) {
            return v;
        } else {
            return check[v] = find(check[v]);
        }
    }

    public static boolean union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);
        if (fv1 == fv2) {
            return false;
        } else {
            check[fv1] = fv2;
            return true;
        }
    }

    public static int solution(List<Edge> edges) {
        Collections.sort(edges);
        int answer = 0;

        int i = 0;
        for (Edge edge : edges) {
            if (i == v - 1) {
                break;
            }
            if (union(edge.v1, edge.v2)) {
                i++;
                answer += edge.cost;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        v = scanner.nextInt();
        e = scanner.nextInt();

        check = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            check[i] = i;
        }
        edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int c = scanner.nextInt();
            edges.add(new Edge(v1, v2, c));
        }

        System.out.println(solution(edges));
        ArrayList<Object> objects = new ArrayList<>();

    }

    public static class Edge implements Comparable<Edge> {
        int v1, v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}

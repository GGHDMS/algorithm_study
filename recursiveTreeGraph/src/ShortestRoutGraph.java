import java.util.*;

public class ShortestRoutGraph {
    static int[] check;
    static int[] dis;
    static int n;
    static List<ArrayList<Integer>> graph;
    static Queue<Integer> queue;

    public void solution(int i, int[] check) {
        queue = new LinkedList<>();
        queue.offer(i);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer poll = queue.poll();
                for (Integer integer : graph.get(poll)) {
                    if (check[integer] == 0) {
                        check[integer] = 1;
                        queue.offer(integer);
                        dis[integer] = dis[poll] + 1;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        ShortestRoutGraph t = new ShortestRoutGraph();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
        }

        check[1] = 1;
        dis[1] = 0;
        t.solution(1, check);
        for (int di : dis) {
            System.out.print(di + " ");
        }
    }
}

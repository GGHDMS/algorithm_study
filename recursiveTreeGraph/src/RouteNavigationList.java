import java.util.ArrayList;
import java.util.Scanner;

public class RouteNavigationList { //정점이 너무 많을 떼 행렬을 사용하는 것은 너무 비효율
    static ArrayList<ArrayList<Integer>> graph;
    static int result = 0;

    public void solution(int i, int n, int[] check) {
        for (Integer integer : graph.get(i)) {
            if (integer == n) {
                result++;
                return;
            }
            if (check[integer] == 1) {
                continue;
            }
            check[integer] = 1;
            solution(integer, n, check);
            check[integer] = 0;
        }

    }

    public static void main(String[] args) {
        RouteNavigationList t = new RouteNavigationList();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] check = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
        }

        check[1] = 1;
        t.solution(1, n, check);
        System.out.println(result);

    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDelivery {
    static int n, m;
    static int[][] map;
    static List<Point> home;
    static List<Point> pizza;
    static Point[] check;
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int i, int t) {
        if (t == m) {
            int sum = 0;
            for (Point h : home) {
                int t_min = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    t_min = Math.min(Math.abs(h.x - check[k].x) + Math.abs(h.y - check[k].y), t_min);
                }
                sum += t_min;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int j = i; j < pizza.size(); j++) {
                check[t] = pizza.get(j);
                dfs(j + 1, t + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        map = new int[n][n];
        check = new Point[m];
        home = new ArrayList<>();
        pizza = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);
        System.out.println(answer);

    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

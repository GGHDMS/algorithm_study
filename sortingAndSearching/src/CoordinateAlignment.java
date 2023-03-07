import java.util.*;

public class CoordinateAlignment {
    public List<Point> solution(int n, List<Point> points) {
        points.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            }
            return p1.x - p2.x;
        });
        return points;
    }

    public static void main(String[] args) {
        CoordinateAlignment t = new CoordinateAlignment();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }
        List<Point> solution = t.solution(n, points);
        for (Point i : solution) {
            System.out.println(i.x + " " + i.y);
        }

    }

    private static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

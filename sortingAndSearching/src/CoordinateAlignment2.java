import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoordinateAlignment2 {
    public List<Point> solution(int n, List<Point> points) {
        Collections.sort(points);
        return points;
    }

    public static void main(String[] args) {
        CoordinateAlignment2 t = new CoordinateAlignment2();
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

    private static class Point implements Comparable<Point> {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y; // 음수값이 나오게 해야된다
            } else {
                return this.x - o.x;
            }
        }
    }
}

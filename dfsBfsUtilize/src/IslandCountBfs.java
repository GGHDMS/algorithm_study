import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandCountBfs {
    static int n;
    static int[][] island;
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static Queue<Point> queue;
    static int answer = 0;

    static void bfs() {
        int ax, ay;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            island[poll.x][poll.y] = 0;
            for (int k = 0; k < 8; k++) {
                ax = poll.x + dx[k];
                ay = poll.y + dy[k];
                if (ax >= 0 & ax < n && ay >= 0 && ay < n && island[ax][ay] == 1) {
                    queue.offer(new Point(ax, ay));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        island = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = scanner.nextInt();
            }
        }

        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1) {
                    answer++;
                    queue.offer(new Point(i, j));
                    bfs();
                }
            }
        }

        System.out.println(answer);
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoBfs {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] xy;
    static Queue<Point> queue;
    static int m, n, ax, ay;
    static int answer = 0;


    public void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Point poll = queue.poll();
                for (int i = 0; i < 4; i ++) {
                    ax = poll.x + dx[i];
                    ay = poll.y + dy[i];
                    if (ax >= 1 && ax <= n && ay >= 1 && ay <= m && xy[ax][ay] == 0) {
                        xy[ax][ay] = 1;
                        queue.offer(new Point(ax, ay));
                    }
                }
            }
            answer++;
        }
        answer--;
    }


    public static void main(String[] args) {
        TomatoBfs t = new TomatoBfs();
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();

        xy = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                xy[i][j] = scanner.nextInt();
            }
        }

        queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (xy[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        t.bfs();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (xy[i][j] == 0) {
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }


    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


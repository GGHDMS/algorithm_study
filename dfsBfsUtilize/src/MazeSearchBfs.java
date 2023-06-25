import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeSearchBfs {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze;
    static Queue<Xy> queue;


    public void bfs(int x, int y) {
        maze[1][1] = 1;
        queue.offer(new Xy(1, 1));

        int ax, ay;
        while (!queue.isEmpty()) {
            Xy xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                ax = xy.x + dx[i];
                ay = xy.y + dy[i];
                if (ax < 1 || ax > 7 || ay < 1 || ay > 7 || maze[ax][ay] != 0) {
                    continue;
                }
                maze[ax][ay] = maze[xy.x][xy.y] + 1;
                queue.offer(new Xy(xy.x + dx[i], xy.y + dy[i]));
            }
        }

    }

    public static void main(String[] args) {
        MazeSearchBfs t = new MazeSearchBfs();
        Scanner scanner = new Scanner(System.in);

        maze = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        queue = new LinkedList<>();

        t.bfs(1, 1);
        if (maze[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(maze[7][7] - 1);
        }
    }

    public static class Xy {
        int x;
        int y;

        public Xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

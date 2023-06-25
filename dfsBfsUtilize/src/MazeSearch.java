import java.util.Scanner;

public class MazeSearch {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze;
    static int answer = 0;

    public void dfs(int i, int j) {
        if (i == 7 && j == 7) {
            answer++;
            return;
        }
        int ax, ay;
        for (int k = 0; k < 4; k++) {
            ax = i + dx[k];
            ay = j + dy[k];
            if (ax < 1 || ax > 7) {
                continue;
            }
            if (ay < 1 || ay > 7) {
                continue;
            }
            if (maze[ax][ay] != 0) {
                continue;
            }
            maze[ax][ay] = 1;
            dfs(ax, ay);
            maze[ax][ay] = 0;
        }
    }


    public static void main(String[] args) {
        MazeSearch t = new MazeSearch();

        Scanner scanner = new Scanner(System.in);

        maze = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        maze[1][1] = 1;
        t.dfs(1, 1);

        System.out.println(answer);
    }
}



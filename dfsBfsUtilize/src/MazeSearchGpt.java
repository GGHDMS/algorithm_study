import java.util.Scanner;

public class MazeSearchGpt {

    private static final int SIZE = 7;
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static int[][] maze;
    private static int answer = 0;

    public void dfs(int i, int j) {
        if (i == SIZE && j == SIZE) {
            answer++;
            return;
        }
        int ax, ay;
        for (int k = 0; k < 4; k++) {
            ax = i + DX[k];
            ay = j + DY[k];
            if (ax < 1 || ax > SIZE || ay < 1 || ay > SIZE || maze[ax][ay] != 0) {
                continue;
            }
            maze[ax][ay] = 1;
            dfs(ax, ay);
            maze[ax][ay] = 0;
        }
    }

    public static void main(String[] args) {
        MazeSearchGpt t = new MazeSearchGpt();

        Scanner scanner = new Scanner(System.in);

        maze = new int[SIZE + 1][SIZE + 1];

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        maze[1][1] = 1;
        t.dfs(1, 1);

        System.out.println(answer);
    }
}

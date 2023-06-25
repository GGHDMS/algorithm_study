import java.util.Scanner;

public class IslandCount {
    static int n;
    static int[][] island;
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int answer = 0;

    static void dfs(int i, int j) {
        int ax, ay;
        for (int k = 0; k < 8; k++) {
            ax = i + dx[k];
            ay = j + dy[k];
            if (ax >= 0 & ax < n && ay >= 0 && ay < n && island[ax][ay] == 1) {
                island[ax][ay] = 0;
                dfs(ax, ay);
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1) {
                    island[i][j] = 0;
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}

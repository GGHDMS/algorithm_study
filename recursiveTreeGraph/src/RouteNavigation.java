import java.util.Scanner;

public class RouteNavigation {
    public static int result = 0;
    public static int[][] array;
    public void solution(int start, int n, int[] check) {
        for (int i = 1; i <= n; i++) {
            if (start == n) {
                result++;
                return;
            }
            if (array[start][i] == 0) {
                continue;
            }
            if (check[i] == 0) {
                int[] clone = check.clone();
                clone[i] = 1;
                solution(i, n, clone);
            }
        }
    }


    public static void main(String[] args) {
        RouteNavigation t = new RouteNavigation();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        array = new int[n + 1][n + 1];
        int[] check = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            array[x][y] = 1;
        }


        check[1] = 1;
        t.solution(1, n, check);
        System.out.println(result);


    }
}

import java.util.Scanner;

public class MaxScore {
    static int max = Integer.MIN_VALUE, n, m;

    public void solution(int[][] arr, int sum, int time, int t) {
        if (time > m) {
            return;
        }
        if (t == n) {
            max = Math.max(sum, max);
        } else {
            solution(arr, sum+arr[t][0], time+arr[t][1], t+1);
            solution(arr, sum, time, t+1);
        }
    }

    public static void main(String[] args) {
        MaxScore t = new MaxScore();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        t.solution(arr, 0, 0, 0);

        System.out.println(max);

    }
}

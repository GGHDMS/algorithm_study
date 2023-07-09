import java.util.Scanner;

public class MaxScore {
    static int[] time;
    static int[] score;
    static int[] dy;
    public static int solution(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= time[i]; j--) {
                dy[j] = Math.max(dy[j], dy[j - time[i]] + score[i]);
            }
        }
        return dy[m];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        time = new int[n];
        score = new int[n];
        dy = new int[m + 1];

        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
            time[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m));

    }
}

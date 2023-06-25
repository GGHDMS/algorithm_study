import java.util.Scanner;

public class MaxSum {
    static int c, n, max = Integer.MIN_VALUE;

    public void solution(int[] arr, int sum, int t) {
        if (sum > c) {
            return;
        }
        if (n == t) {
            max = Math.max(sum, max);
            return;
        }

        solution(arr, sum + arr[t], t + 1);
        solution(arr, sum, t + 1);
    }

    public static void main(String[] args) {
        MaxSum t = new MaxSum();
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        t.solution(arr, 0, 0);
        System.out.println(max);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class TwoMinuteSearchWhile {
    public int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;
        int k = 0;
        while (lt <= rt) {
            k = (rt + lt) / 2;
            if (arr[k] > m) {
                rt = k - 1;
            } else if (arr[k] < m) {
                lt = k + 1;
            } else {
                break;
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        TwoMinuteSearchWhile t = new TwoMinuteSearchWhile();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, m, arr));

    }
}

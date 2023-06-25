import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinExchange {
    static Integer[] arr;
    static int n, m, minCoin = Integer.MAX_VALUE;

    public void solution(int sum, int t) {
        if (sum > m || t >= minCoin) {
            return;
        }
        if (sum == m) {
            minCoin = t;
        } else {
            for (int i = 0; i < n; i++) {
                solution(sum + arr[i], t + 1);
            }
        }
    }

    public static void main(String[] args) {
        CoinExchange t = new CoinExchange();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        m = scanner.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());
        t.solution(0, 0);

        System.out.println(minCoin);
    }
}

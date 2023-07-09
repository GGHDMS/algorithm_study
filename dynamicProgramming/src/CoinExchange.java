import java.util.Arrays;
import java.util.Scanner;

public class CoinExchange {
    static int[] coin;
    static int[] dy;

    public static int solution(int n, int m) {
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[m];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        System.out.println(solution(n, m));

    }

}

package algorithm_basics_one._400;

import java.util.Scanner;

public class Tiling2xn_v2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[1001];

        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
        }

        System.out.println(arr[n]);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    static int n, m;

    public void solution(int[] arr, int[] check, int[] answer, int t) {
        if (t == m) {
            for (int j : answer) {
                System.out.print(j + " ");
            }
            System.out.println();
            return;
        }

        for (int j = 0; j < n; j++) {
            if (check[j] != 1) {
                check[j] = 1;
                answer[t] = arr[j];
                solution(arr, check, answer, t + 1);
                check[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Permutation t = new Permutation();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] arr = new int[n];
        int[] check = new int[n];
        int[] answer = new int[m];

        for (int i = 0; i < n; i++) {
             arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);


        t.solution(arr, check, answer, 0);
    }
}

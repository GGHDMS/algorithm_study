import java.util.Scanner;

public class Fibonacci {
    static int[] arr;

    public int solution(int n) {
        if (arr[n] > 0) {
            return arr[n];
        }
        if (n == 1) {
            return arr[n] = 1;
        } else if (n == 2) {
            return arr[n] = 1;
        } else {
            return arr[n] = solution(n - 1) + solution(n - 2);
        }
    }


    public static void main(String[] args) {
        Fibonacci t = new Fibonacci();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Fibonacci.arr = new int[n + 1];
        t.solution(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

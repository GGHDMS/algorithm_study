import java.util.Scanner;

public class SequenceGuess {
    int[][] arr = new int[10][10];
    static boolean flag = false;
    static int n, f;
    static int[] multi, check, answer;

    public void solution(int sum, int t) {
        if (flag) {
            return;
        }
        if (t == n) {
            if (sum == f) {
                for (int i : answer) {
                    System.out.print(i + " ");
                }
                System.out.println();
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    answer[t] = i;
                    solution(sum + multi[t] * i, t + 1) ;
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SequenceGuess t = new SequenceGuess();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        f = scanner.nextInt();

        multi = new int[n];
        answer = new int[n];
        check = new int[n + 1];

        for (int i = 0; i < n; i++) {
            multi[i] = t.combination(n-1, i);
        }

        t.solution(0, 0);
    }

    public int combination(int n, int r) {
        if (arr[n][r] > 0) return arr[n][r];
        if(n == r || r == 0) return 1;
        else return arr[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}

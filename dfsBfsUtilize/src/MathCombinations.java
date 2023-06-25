import java.util.Scanner;

public class MathCombinations {
    int[][] arr = new int[35][35];

    public int solution(int n, int r) {
        if (arr[n][r] > 0) return arr[n][r];
        if(n == r || r == 0) return 1;
        else return arr[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
    }

    public static void main(String[] args) {
        MathCombinations t = new MathCombinations();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int answer = t.solution(n, r);

        System.out.println(answer);
    }
}

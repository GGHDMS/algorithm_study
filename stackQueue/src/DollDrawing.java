import java.util.Scanner;
import java.util.Stack;

public class DollDrawing {
    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            int k = moves[i] - 1;
            for (int j = 0; j < n; j++) {
                int x = board[j][k];
                if (x == 0) {
                    continue;
                }
                board[j][k] = 0;
                if (!stack.isEmpty() && stack.peek() == x) {
                    stack.pop();
                    answer+=2;
                }
                else {
                    stack.push(x);
                }
                break;

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DollDrawing t = new DollDrawing();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, board, m, moves));
    }
}

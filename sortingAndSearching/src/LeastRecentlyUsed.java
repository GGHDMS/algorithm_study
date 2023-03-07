import java.util.Scanner;

public class LeastRecentlyUsed {
    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];
        for (int i : arr) {
            int j;
            for (j = 0; j < s; j++) {
                if (i == answer[j]) {
                    for (int k = j; k > 0; k--) {
                        answer[k] = answer[k - 1];
                    }
                    break;
                }
            }
            if (j == s) {
                for (int k = s - 1; k > 0; k--) {
                    answer[k] = answer[k - 1];
                }
            }
            answer[0] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        LeastRecentlyUsed t = new LeastRecentlyUsed();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] answer = t.solution(s, n, arr);
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }
}

import java.util.Scanner;

public class SubSequence {
    static int[] arr;
    static int[] dy;

    public static int solution(int n) {
        int answer = 0;
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;

            answer = Math.max(dy[i], answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        arr = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n));
    }
}

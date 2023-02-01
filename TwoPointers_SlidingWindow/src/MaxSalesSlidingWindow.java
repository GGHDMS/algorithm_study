import java.util.Scanner;

public class MaxSalesSlidingWindow {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer += arr[i];
        }
        int sum = answer;
        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];
            if (answer < sum) {
                answer = sum;
            }
        }
        //2중 for 너무 느리다

        return answer;
    }

    public static void main(String[] args) {
        MaxSalesSlidingWindow t = new MaxSalesSlidingWindow();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
    }
}

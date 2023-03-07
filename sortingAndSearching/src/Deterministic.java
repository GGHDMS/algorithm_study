import java.util.Arrays;
import java.util.Scanner;

public class Deterministic {
    public int solution(int n, int m, int[] arr) {
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0 ;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = arr[i];
                    count++;
                } else {
                    sum += arr[i];
                }
            }
            if (count >= m) {
                lt = mid + 1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Deterministic t = new Deterministic();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, m, arr));
    }
}

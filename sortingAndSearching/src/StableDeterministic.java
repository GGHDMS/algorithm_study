import java.util.Arrays;
import java.util.Scanner;

public class StableDeterministic {
    public int solution(int n, int c, int[] arr) {
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int temp = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                if (arr[i] - arr[temp] >= mid) {
                    count++;
                    temp = i;
                }
            }
            if (count >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        StableDeterministic t = new StableDeterministic();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, c, arr));
    }
}

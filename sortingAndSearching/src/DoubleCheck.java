import java.util.Arrays;
import java.util.Scanner;

public class DoubleCheck { // hashSet 으로 하는게 좋지만 의미가 없기 때문에
    public char solution(int n, int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 'D';
            }
        }
        return 'U';
    }

    public static void main(String[] args) {
        DoubleCheck t = new DoubleCheck();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, arr));
    }
}

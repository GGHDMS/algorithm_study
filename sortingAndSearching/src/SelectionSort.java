import java.util.List;
import java.util.Scanner;

public class SelectionSort {
    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }


    public static void main(String[] args) {
        SelectionSort t = new SelectionSort();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] answer = t.solution(n, arr);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}

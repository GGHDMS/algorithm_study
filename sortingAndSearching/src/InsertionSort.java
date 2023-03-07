import java.util.Scanner;

public class InsertionSort {
    public int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertionSort t = new InsertionSort();
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

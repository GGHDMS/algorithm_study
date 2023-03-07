import java.util.Arrays;
import java.util.Scanner;

public class TwoMinuteSearch {
    public int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        return binarySearch(0, n - 1, m, arr);
    }

    public int binarySearch(int lt, int rt, int m, int[] arr) {
        int answer;
        int k = (lt + rt) / 2;
        if (rt - lt == 0) {
            return k + 1;
        }
        if (arr[k] > m) {
            answer = binarySearch(lt, k - 1, m, arr);
        } else if (arr[k] < m) {
            answer = binarySearch(k + 1, rt, m, arr);
        } else {
            return k + 1;
        }
        return answer;
    }


    public static void main(String[] args) {
        TwoMinuteSearch t = new TwoMinuteSearch();
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

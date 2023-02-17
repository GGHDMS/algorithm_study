import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class KthLargestNumber {
    public int solution(int n, int k, int[] arr) {
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int count=1;
        for (Integer i : set) {
            if (count++ == k){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        KthLargestNumber t = new KthLargestNumber();
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

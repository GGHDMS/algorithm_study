import java.util.Arrays;
import java.util.Scanner;

public class SubsetOfEqualSums {

    static int n;
    static String answer = "NO";

    public void solution(int[] array, int sum, int t) {
        if (n == t) {
            return;
        } else {
            if (sum * 2 == Arrays.stream(array).sum()) {
                answer = "YES";
            }

            if (answer.equals("YES")) {
                return;
            }
            solution(array, sum + array[t], t + 1);
            solution(array, sum, t + 1);
        }
    }

    public static void main(String[] args) {
        SubsetOfEqualSums t = new SubsetOfEqualSums();

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        t.solution(array, 0, 0);

        System.out.println(answer);
    }
}

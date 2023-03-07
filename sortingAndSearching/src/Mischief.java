import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mischief {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] temp = arr.clone();
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Mischief t = new Mischief();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ArrayList<Integer> solution = t.solution(n, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

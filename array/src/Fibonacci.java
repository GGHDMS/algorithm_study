import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    public int[] solution(int n){
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i=2; i < n; i++){
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Fibonacci t = new Fibonacci();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] solution = t.solution(n);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

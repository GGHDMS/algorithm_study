import java.util.Scanner;

public class RecursiveFunction {
    public void solution(int n) {
        if (n == 0) {
            return;
        }
        solution(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        RecursiveFunction t = new RecursiveFunction();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        t.solution(n);
    }

}

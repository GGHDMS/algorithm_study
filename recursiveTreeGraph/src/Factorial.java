import java.util.Scanner;

public class Factorial {
    public int solution(int n) {
        if (n == 1) {
            return 1;
        }
        return n * solution(n - 1);
    }


    public static void main(String[] args) {
        Factorial t = new Factorial();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(t.solution(n));
    }
}

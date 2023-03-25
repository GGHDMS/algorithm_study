import java.util.Scanner;

public class BinaryNumbers {
    public void solution(int n) {
        if (n == 0) {
            return;
        }
        solution(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        BinaryNumbers t = new BinaryNumbers();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        t.solution(n);
    }
}

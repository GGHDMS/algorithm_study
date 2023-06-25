import java.util.Scanner;

public class Combination {
    static int n, m;
    static int[] check;


    public void solution(int t, int i) {
        if (t == m) {
            for (int num : check) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int j = i; j <= n; j++) {
                check[t] = j;
                solution(t + 1, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        Combination t = new Combination();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        check = new int[m];

        t.solution(0, 1);


    }
}

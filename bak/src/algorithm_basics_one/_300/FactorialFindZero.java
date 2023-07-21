package algorithm_basics_one._300;

import java.util.Scanner;

public class FactorialFindZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n % 5 != 0) {
            n--;
        }
        int answer = 0;
        for (int i = n; i >= 5; i -= 5) {
            int j = i;
            while (j % 5 == 0) {
                j /= 5;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

package algorithm_basics_one._303;

import java.util.Scanner;

public class Arithmetic2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();

        int result = 0;
        int num;
        int idx = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                num = c - '0';
            } else {
                num = c - 55;
            }
            result += Math.pow(n, idx++) * num;
        }
        System.out.println(result);
    }
}

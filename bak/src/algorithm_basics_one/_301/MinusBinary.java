package algorithm_basics_one._301;

import java.util.Scanner;

public class MinusBinary {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            sb.append(0);
        } else {
            while (n != 1) {
                sb.append(Math.abs(n % -2));

                n = (int) Math.ceil((double) n / -2);
            }
            sb.append(n);
        }
        System.out.println(sb.reverse());
    }
}

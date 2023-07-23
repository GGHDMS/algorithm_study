package algorithm_basics_one._301;

import java.util.Scanner;

public class BinaryToOctal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        if (n % 3 == 2) {
            sb.append((s.charAt(0) - '0') * 2 + s.charAt(1) - '0');
        } else if (n % 3 == 1) {
            sb.append(s.charAt(0) - '0');
        }

        for (int i = n % 3; i < n; i += 3) {
            sb.append((s.charAt(i) - '0') * 4 + (s.charAt(i + 1) - '0') * 2 + (s.charAt(i + 2) - '0'));
        }

        System.out.println(sb);
    }
}

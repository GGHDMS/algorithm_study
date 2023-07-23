package algorithm_basics_one._301;

import java.util.Scanner;

public class OctalToBinary {

    public static void main(String[] args) {
        String[] eight = {"000","001","010","011","100","101","110","111"};
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = scanner.next();

        if (s.length() == 1 && s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for (char c : s.toCharArray()) {
            sb.append(eight[c - '0']);
        }

        int i = 0;
        while (sb.charAt(i) == '0') {
            i++;
        }
        System.out.println(sb.substring(i));
    }
}

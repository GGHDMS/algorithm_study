package algorithm_basics_one._203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Suffix {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        String s = scanner.next();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }

        Collections.sort(list);
        for (String s1 : list) {
            sb.append(s1).append("\n");
        }
        System.out.println(sb);
    }
}

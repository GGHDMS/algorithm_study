package algorithm_basics_one._203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if (('a' <= c && c <= 'm') || ('A' <= c && c <= 'M')) {
                sb.append(Character.toChars(c + 13));
            } else if (('n' <= c && c <= 'z') || ('N' <= c && c <= 'Z')) {
                sb.append(Character.toChars(c - 13));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

}

package algorithm_basics_one._203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringAnalysis {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = "";
        while ((s = br.readLine()) != null) {
            int small = 0;
            int big = 0;
            int num = 0;
            int blank = 0;
            for (char c : s.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    small++;
                } else if ('A' <= c && c <= 'Z') {
                    big++;
                } else if ('0' <= c && c <= '9') {
                    num++;
                } else {
                    blank++;
                }
            }
            sb.append(small).append(" ")
                    .append(big).append(" ")
                    .append(num).append(" ")
                    .append(blank).append("\n");
        }
        System.out.println(sb);
    }
}

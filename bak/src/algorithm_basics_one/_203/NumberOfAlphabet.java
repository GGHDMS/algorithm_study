package algorithm_basics_one._203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfAlphabet {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            arr[25 - ('z' - c)] ++;
        }

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

package algorithm_basics_one._203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindAlphabetIndex {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if (arr[a] == -1) {
                arr[a] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}

package algorithm_basics_one._201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class IronRod {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addLast(s.charAt(i));
            } else {
                deque.pollLast();
                if (s.charAt(i - 1) == '(') {
                    answer += deque.size();
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

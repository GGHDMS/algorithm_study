package algorithm_basics_one._203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixExpressionHard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int priority(char c) {
        if (c == '(') {
            return -1;
        } else if (c == '+' || c == '-') {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Deque<Character> operator = new ArrayDeque<>();

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                operator.addLast(c);
            } else if (c == ')') {
                while (operator.peekLast() != '(') {
                    sb.append(operator.pollLast());
                }
                operator.pollLast();
            } else {
                while (!operator.isEmpty() && priority(operator.peekLast()) >= priority(c)) {
                    sb.append(operator.pollLast());
                }
                operator.addLast(c);
            }
        }
        while (!operator.isEmpty()) {
            sb.append(operator.pollLast());
        }
        System.out.println(sb);
    }

}

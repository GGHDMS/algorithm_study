package algorithm_basics_one._203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixExpression {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Double> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Double[] arr = new Double[n];
        String s = br.readLine();

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                deque.addLast((Double) arr[c-'A']);
            } else {
                double b = deque.pollLast();
                double a = deque.pollLast();
                if (c == '+') {
                    deque.addLast(a + b);
                } else if (c == '-') {
                    deque.addLast(a - b);
                } else if (c == '*') {
                    deque.addLast(a * b);
                } else if (c == '/') {
                    deque.addLast(a / b);
                }
            }
        }

        System.out.printf("%.2f", deque.pollLast());
    }
}

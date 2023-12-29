package leetcode.week5;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String i : tokens) {
            if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                int b = deque.removeLast();
                int a = deque.removeLast();
                deque.add(operator(a, b, i));
            } else {
                deque.add(Integer.parseInt(i));
            }
        }


        return deque.removeLast();
    }

    public int operator(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}

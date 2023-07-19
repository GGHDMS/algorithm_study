package algorithm_basics_one._201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class FlipTheWord_V2 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        String s = bf.readLine();
        sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        boolean flag = true;
        for (char c : s.toCharArray()) {
            if (c == '<') {
                flag = false;
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                }
                deque.addLast(c);
            } else if (c == '>') {
                flag = true;
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                }
                sb.append(c);
            } else if (c == ' ') {
                if (flag) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                    }
                    sb.append(c);
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                    }
                    sb.append(c);
                }
            } else {
                deque.addLast(c);
            }
        }
        if (flag) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
            }
            sb.append(' ');
        } else {
            deque.addLast(' ');
        }
        System.out.println(sb);
    }


}

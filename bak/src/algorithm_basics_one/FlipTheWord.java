package algorithm_basics_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class FlipTheWord {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (Character c : s.toCharArray()) {
                if (c == ' ') {
                    while (!stack.empty()) {
                        stringBuilder.append(stack.pop());
                    }
                    stringBuilder.append(" ");
                } else {
                    stack.push(c);
                }
            }
            while (!stack.empty()) {
                stringBuilder.append(stack.pop());
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }


}

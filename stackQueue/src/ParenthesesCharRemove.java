import java.util.Scanner;
import java.util.Stack;

public class ParenthesesCharRemove {
    StringBuilder answer = new StringBuilder();

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') ;
            } else {
                stack.push(c);
            }
        }
        for (Character character : stack) {
            answer.append(character);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        ParenthesesCharRemove t = new ParenthesesCharRemove();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));

    }
}

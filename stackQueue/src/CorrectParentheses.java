import java.util.Scanner;
import java.util.Stack;

public class CorrectParentheses {
    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() == ')') {
                    return "NO";
                }
            } else {
                stack.push(c);
            }
        }
        if(stack.size() != 0){
            return "NO";
        }
        return "YES";
    }


    public static void main(String[] args) {
        CorrectParentheses t = new CorrectParentheses();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }
}

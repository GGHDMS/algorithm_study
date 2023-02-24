import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }
            else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (c) {
                    case '+' : stack.push(num1 + num2); break;
                    case '*' : stack.push(num1 * num2); break;
                    case '-' : stack.push(num1 - num2); break;
                    case '/' : stack.push(num1 / num2);
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Postfix t = new Postfix();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));

    }
}

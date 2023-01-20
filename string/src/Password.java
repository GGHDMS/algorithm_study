import java.util.Scanner;

public class Password {
    public String solution(int n, String str){
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(str.substring(i * 7, i * 7 + 7).replace("#", "1").replace("*", "0"), 2);
            answer.append(Character.toChars(temp));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Password t = new Password();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(t.solution(n, str));
    }
}

import java.util.Scanner;

class GetNumber {
    public int solution(String str){
        // 아스키 코드로 해도 된다.

        StringBuilder answer = new StringBuilder();
        for(char x : str.toCharArray()){
            if (Character.isDigit(x))
                answer.append(x);
        }
        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) {
        GetNumber t = new GetNumber();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }
}

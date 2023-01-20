import java.util.Scanner;

class CharDeduplication {
    public String solution(String str){
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(i == str.indexOf(str.charAt(i)))
                answer.append(str.charAt(i));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        CharDeduplication t = new CharDeduplication();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }
}

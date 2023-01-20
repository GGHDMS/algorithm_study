import java.util.Scanner;

public class CharChange {
    public String solution(String str){
        StringBuilder answer = new StringBuilder();
        for(char x : str.toCharArray()){
            if(Character.isLowerCase(x))
                answer.append(Character.toUpperCase(x));
            else
                answer.append(Character.toLowerCase(x));
        }
        return answer.toString();
    }

    static public void main(String[] args){
        CharChange charChange = new CharChange();
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(charChange.solution(next));
    }
}

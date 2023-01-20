import java.util.Scanner;

public class StringFind {
    public int solution(String str, char t){
        int answer = 0;
        str=str.toUpperCase();
        t=Character.toUpperCase(t);
//        for(int i=0; i < str.length() ; i++){
//            if(str.charAt(i)==t){
//                answer++;
//            }
//        }
        for(char x : str.toCharArray()){
            if(x==t) answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        StringFind stringFind = new StringFind();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        System.out.println(stringFind.solution(str, c));
    }
}

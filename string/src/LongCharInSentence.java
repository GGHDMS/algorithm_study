import java.util.Scanner;

public class LongCharInSentence {
    public String solution(String str){
        String answer = "";
        int m= Integer.MIN_VALUE, pos;
//        String[] array = str.split(" ");
//        for(String x : array){
//            int len = x.length();
//            if(len > m){
//                answer = x;
//                m = len;
//            }
//        }

        while((pos=str.indexOf(' '))!=-1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m){
                m=len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m) answer = str;
        return answer;
    }

    public static void main(String[] args){
        LongCharInSentence longCharInSentence = new LongCharInSentence();
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(longCharInSentence.solution(str));
    }
}

import javax.script.ScriptContext;
import java.util.Scanner;

public class AlphabetPalindrome {
    public String solution(String str){
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
//        System.out.println("str = " + str);
//        int lx=0, rx=str.length()-1;
//        while (lx<rx){
//            if(str.charAt(lx) != str.charAt(rx)){
//                return "NO";
//            }
//            lx++;
//            rx--;
//        }
//        return "YES";
        String tmp = new StringBuilder(str).reverse().toString();
        if(tmp.equals(str))
            return "YES";
        return "NO";

    }
    public static void main(String[] args) {
        AlphabetPalindrome t = new AlphabetPalindrome();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(t.solution(str));
    }
}

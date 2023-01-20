import java.util.Scanner;

class Palindrome {
    public String solution(String str){
//        str = str.toUpperCase();
//        int lx=0, rx=str.length()-1;
//        while (lx<rx){
//            if(str.charAt(lx) != str.charAt(rx)){
//                return "NO";
//            }
//            lx++;
//            rx--;
//        }
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp))
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Palindrome t = new Palindrome();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }
}

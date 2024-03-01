import java.util.*;

public class Baek1541 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int i=0;
        int target = 0;
        int minus = 0;
        boolean m = false;
        for(int j= 0 ;j<s.length();j++){
            if(s.charAt(j) == '+'){
                if(m == true){
                    minus += Integer.parseInt(s.substring(i, j));
                } else {
                    target += Integer.parseInt(s.substring(i, j));
                }
                i = j + 1;
            } else if(s.charAt(j) == '-'){
                if (m == true){
                    target -= minus;
                    minus = Integer.parseInt(s.substring(i, j));
                } else{
                    m = true;
                    target += Integer.parseInt(s.substring(i, j));
                }
                i = j + 1;
            }  
        }

        if (m == true){
            minus += Integer.parseInt(s.substring(i, s.length()));
        } else{
            target += Integer.parseInt(s.substring(i, s.length()));
        }
        System.out.println(target - minus);
    }
}

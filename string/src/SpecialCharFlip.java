import java.util.Scanner;

class SpecialCharFlip {
    public String solution(String str){
        char[] c = str.toCharArray();
        int lt=0, rt=str.length()-1;
        while(lt<rt){
            if(!Character.isAlphabetic(c[lt])) lt++;
            else if(!Character.isAlphabetic(c[rt])) rt--;
            else{
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(c);
    }

    static public void main(String[] args){
        SpecialCharFlip t = new SpecialCharFlip();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(t.solution(str));
    }
}

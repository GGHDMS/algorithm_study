import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class charFlip {

    public List<String> solution(int n, String[] str){
        List<String> answer = new ArrayList<>();
//        for(String x : str){
//            answer.add(new StringBuilder(x).reverse().toString());
//        }

        for(String x : str){
            char[] c = x.toCharArray();
            int lt = 0 , rt = x.length() - 1;
            while(lt<rt){
                char tmp = c[lt];
                 c[lt] = c[rt];
                 c[rt] = tmp;
                 lt++;
                 rt--;
            }
            answer.add(String.valueOf(c));
        }
        return answer;

    }

    static public void main(String[] args){
        charFlip t = new charFlip();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = scanner.next();
        }
        for (String x : t.solution(n, str)){
            System.out.println(x);
        }

    }
}

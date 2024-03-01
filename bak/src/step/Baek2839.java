import java.util.*;

public class Baek2839 {
    

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dfs(n, 0);

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }

    static void dfs(int n, int sum){
        if (answer != Integer.MAX_VALUE){
            return;
        }

        if(n == 0){
            answer = Math.min(answer, sum);
        } else if( n < 0){
            return;
        }
        dfs(n-5, sum+1);
        dfs(n-3, sum+1);
    }
}

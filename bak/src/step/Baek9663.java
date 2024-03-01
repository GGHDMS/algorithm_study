import java.util.*;

public class Baek9663 {
    static int n;
    static int answer = 0;
    static int[] map;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n];
        dfs(0);
        
        System.out.println(answer);
    }

    static void dfs(int col){
        if(col == n){
            answer ++;
            return;
        }

        for(int i =0 ;i<n;i++){
            map[col] = i;

            if(possible(col)){
                dfs(col + 1);
            }
        }
    }

    static boolean possible(int col){
        for(int i=0;i<col;i++){
            if(map[i] == map[col]){
                return false;
            } 
            
            else if(Math.abs(map[i] - map[col]) == col - i){
                return false;
            }
        }

        return true;
    }
}

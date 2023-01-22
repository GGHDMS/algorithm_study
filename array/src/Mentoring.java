import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mentoring {
    public int solution(int n, int m, Integer[][] arr){
        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                boolean flog = true;
                for (int k=0; k<m;k++){
                    List<Integer> list = Arrays.asList(arr[k]);
                    if (list.indexOf(i+1) >= list.indexOf(j+1)){
                        flog = false;
                        break;
                    }
                }
                if(flog){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Mentoring t = new Mentoring();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Integer[][] arr = new Integer[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(t.solution(n, m, arr));
    }

}

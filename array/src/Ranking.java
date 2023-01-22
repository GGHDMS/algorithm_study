import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ranking {
    public int[] solution(int n, int[] arr){
        int[] answer = new int[n];
        for (int i=0; i< n; i++){
            int cnt=1;
            for(int j=0;j<n;j++){
                if(arr[j]>arr[i]){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }


    public static void main(String[] args) {
        Ranking t = new Ranking();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        int[] solution = t.solution(n, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisibleStudent {
    public int solution(int n, int[] arr){
        int answer = 1;
        int tall = arr[0];
        for (int i = 1 ; i < n; i++){
            if(arr[i] > tall) {
                answer++;
                tall = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        VisibleStudent t = new VisibleStudent();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, arr));
    }
}


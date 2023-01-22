import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BigNum {
    public List<Integer> solution(int n, int[] arr){
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1 ; i < n; i++){
            if(arr[i] > arr[i-1])
                answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        BigNum t = new BigNum();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        List<Integer> solution = t.solution(n, arr);
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}

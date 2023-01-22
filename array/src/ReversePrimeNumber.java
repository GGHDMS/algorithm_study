import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePrimeNumber {
    public boolean isPrime(int num){
        if (num == 1){
            return false;
        }
        for (int i=2;i<num/2;i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }

    public List<Integer> solution(int n, int[] arr){
        List<Integer> answer = new ArrayList<>();
        for (int i=0;i<n;i++){
            int res=0;
            int tmp = arr[i];
            while (tmp != 0 ){
                int t = tmp % 10;
                res = res*10+t;
                tmp = tmp/10;
            }
            if (isPrime(res)){
                answer.add(res);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ReversePrimeNumber t = new ReversePrimeNumber();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0 ; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        List<Integer> solution = t.solution(n, arr);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
    }
}

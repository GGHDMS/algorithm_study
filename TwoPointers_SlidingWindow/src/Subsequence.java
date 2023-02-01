import java.util.Scanner;

public class Subsequence {
//    public int solution(int n, int m, int[] arr) {
//        int answer=0, sum=0;
//        int lx=0, rx=0;
//        while (rx<n){
//            if (sum < m){
//                sum+=arr[rx++];
//            } else if (sum>m){
//                sum-=arr[lx++];
//            }
//            if (sum == m){
//                answer++;
//                sum-=arr[lx++];
//            }
//        }
//        return answer;
//    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Subsequence t = new Subsequence();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, m, arr));


    }
}

import java.util.Scanner;

public class GridMaxSum {
    public int solution(int num, int[][] arr){
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i=0;i<num;i++){
            sum1=sum2=0;
            for(int j=0;j<num;j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1=sum2=0;
        for (int i=0;i<num;i++){
            sum1 += arr[i][i];
            sum2 += arr[num-i-1][num-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }


    public static void main(String[] args) {
        GridMaxSum t = new GridMaxSum();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(t.solution(n, arr));

    }
}

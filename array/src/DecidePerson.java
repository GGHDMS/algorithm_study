import java.util.Scanner;

public class DecidePerson {
    public int solution(int n, int[][] arr){
        int answer = 0, max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            int tmp=0;
            for (int j=0; j<n; j++){
                for (int k =0; k<5; k++){
                    if(arr[i][k] == arr[j][k]){
                        tmp++;
                        break;
                    }
                }
            }
            if(max < tmp){
                answer = i;
                max=tmp;
            }
        }
        return answer+1;
    }


    public static void main(String[] args) {
        DecidePerson t = new DecidePerson();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][5];
        for (int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(t.solution(n, arr));
    }
}

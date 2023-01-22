import java.util.Scanner;

public class ScoreCheck {
    public int solution(int n, int[] arr){
        int answer = 0, tmp=1;
        for (int i : arr) {
            if(i==1){
                answer+=tmp;
                tmp++;
            }
            else {
                tmp=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ScoreCheck t = new ScoreCheck();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, arr));
    }
}

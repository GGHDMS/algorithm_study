import java.util.Scanner;

public class Peak {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1,  0, -1};

    public int solution(int n, int[][] arr){
        int answer=n*n;
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    int nx=i + dx[k];
                    int ny=j + dy[k];
                    if (nx>=0 && nx < n && ny>=0 && ny < n && arr[nx][ny] >= arr[i][j]){
                        answer--;
                        break;
                    }
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Peak t = new Peak();
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

import java.util.Scanner;

public class ContinuousNumberSum {
    public int solution(int n) {
        int lt = 1;
        int answer = 0, sum = 0;
        for (int i = 1; i <= n / 2 + 1; i++) {
            sum += i;
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= lt;
                lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        ContinuousNumberSum t = new ContinuousNumberSum();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int solution = t.solution(n);
        System.out.println(solution);

    }
}

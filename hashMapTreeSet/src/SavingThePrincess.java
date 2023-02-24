import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavingThePrincess {
    public int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() != 1) {
            for (int j = 1; j < k; j++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }


    public static void main(String[] args) {
        SavingThePrincess t = new SavingThePrincess();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(t.solution(n, k));
    }
}

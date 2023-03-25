import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> queue = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int poll = queue.poll();
                for (int di : dis) {
                    if (di + poll > 0 && di + poll <= 10000 && ch[di + poll] == 0) {
                        if (di + poll == e) {
                            return answer + 1;
                        }
                        ch[di + poll] = 1;
                        queue.offer(di + poll);
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        FindCalf t = new FindCalf();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(t.BFS(s, n));
    }
}

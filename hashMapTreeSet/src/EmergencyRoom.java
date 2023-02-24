import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }

        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            boolean go = true;
            for (Person x : queue) {
                if (x.getPriority() > tmp.getPriority()) {
                    queue.offer(tmp);
                    go = false;
                    break;
                }
            }
            if (go) {
                answer++;
                if (tmp.index == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        EmergencyRoom t = new EmergencyRoom();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(t.solution(n, m, arr));

    }

    static class Person {
        private final int index;
        private final int priority;

        public Person(int index, int num) {
            this.index = index;
            this.priority = num;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }
    }

}

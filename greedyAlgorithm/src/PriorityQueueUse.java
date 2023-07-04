import java.util.*;

public class PriorityQueueUse {

    public static int solution(int max, List<Lecture> arr, int n) {
        int answer = 0;

        Collections.sort(arr);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = max; i > 0; i--) {
            for (; j < n; j++) {
                if (arr.get(j).period < i) {
                    break;
                }
                queue.offer(arr.get(j).money);
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = Integer.MIN_VALUE;


        List<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int p = scanner.nextInt();
            if (p > max) {
                max = p;
            }
            arr.add(new Lecture(m, p));
        }

        System.out.println(solution(max, arr, n));
    }

    public static class Lecture implements Comparable<Lecture> {
        int money;
        int period;

        public Lecture(int money, int period) {
            this.money = money;
            this.period = period;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.period - this.period;
        }
    }
}

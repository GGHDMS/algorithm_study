import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WeddingCeremony {

    public static int solution(List<Time> times) {
        int answer = 0, current = 0;

        Collections.sort(times);

        for (Time time : times) {
            if (time.w == 'e') {
                current--;
            } else {
                current++;
            }

            if (answer < current) {
                answer = current;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Time> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            times.add(new Time(scanner.nextInt(), 's'));
            times.add(new Time(scanner.nextInt(), 'e'));
        }

        System.out.println(solution(times));
    }

    static class Time implements Comparable<Time> {
        int t;
        char w;

        public Time(int t, char w) {
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Time o) {
            if (this.t == o.t) {
                return this.w - o.w;
            } else {
                return this.t - o.t;
            }
        }
    }
}

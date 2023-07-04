import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomAssignment {
    public static int solution(List<Meet> meetList, int n) {
        int answer = 0;
        int check = Integer.MIN_VALUE;
        Collections.sort(meetList);

        for (Meet meet : meetList) {
            if (meet.start >= check) {
                check = meet.finish;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Meet> meetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int finish = scanner.nextInt();
            meetList.add(new Meet(start, finish));
        }

        System.out.println(solution(meetList, n));

    }

    static class Meet implements Comparable<Meet>{
        int start, finish;

        public Meet(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Meet o) {
            if (o.finish == this.finish) {
                return this.start - o.start;
            }
            return this.finish - o.finish;
        }
    }
}


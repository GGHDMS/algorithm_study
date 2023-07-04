import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PickPlayer {
    public static int solution(List<Body> array, int n) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        Collections.sort(array);

        for (Body body : array) {
            if (body.weight > max) {
                max = body.weight;
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Body> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            array.add(new Body(height, weight));
        }

        System.out.println(solution(array, n));


    }


    static class Body implements Comparable<Body> {
        int height;
        int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }


}

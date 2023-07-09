import java.util.*;

public class BuildTheTallestTower {
    static List<Box> arr;
    static int[] dy;

    public static int solution(int n) {
        arr.sort(Collections.reverseOrder());
        int answer = dy[0] = arr.get(0).height;

        for (int i = 1; i < n; i++) {
            int num = arr.get(i).height;
            for (int j = i; j > 0; j--) {
                if (arr.get(j - 1).weight > arr.get(i).weight) {
                    if (dy[j - 1] + arr.get(i).height > num) {
                        num = dy[j-1] + arr.get(i).height;
                    }
                }
            }
            dy[i] = num;
            answer = Math.max(dy[i], answer);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dy = new int[n];
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int b = scanner.nextInt();
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            arr.add(new Box(b, h, w));
        }

        System.out.println(solution(n));
    }

    static class Box implements Comparable<Box> {
        int base;
        int height;
        int weight;

        public Box(int base, int height, int weight) {
            this.base = base;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Box o) {
            return this.base - o.base;
        }
    }
}
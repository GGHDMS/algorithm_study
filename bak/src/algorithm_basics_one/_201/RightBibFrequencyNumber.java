package algorithm_basics_one._201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RightBibFrequencyNumber {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Deque<Point> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] answer = new int[n + 1];
        Arrays.fill(answer, -1);

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(st.nextToken());
            hashMap.put(k, hashMap.getOrDefault(k, 0) + 1);
            arr[i] = k;
        }

        for (int i = 1; i <= n; i++) {
            while (!deque.isEmpty() && deque.peekLast().freq < hashMap.get(arr[i])) {
                answer[deque.pollLast().idx] = arr[i];
            }
            deque.addLast(new Point(i, arr[i], hashMap.get(arr[i])));
        }

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static class Point {
        int idx;
        int num;
        int freq;

        public Point(int idx, int num, int freq) {
            this.idx = idx;
            this.num = num;
            this.freq = freq;
        }
    }

}

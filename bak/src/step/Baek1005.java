import java.util.*;
import java.io.*;

public class Baek1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t;
    static int n, k;

    static int[] delay;
    static int w;
    static int[] canBuild;
    static List<List<Integer>> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        t = Integer.parseInt(br.readLine());

        for (int term = 0; term < t; term++) {
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            delay = new int[n + 1];
            canBuild = new int[n + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                canBuild[b]++;
            }

            w = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
                return delay[o1] - delay[o2];
            });

            for (int i = 1; i <= n; i++) {
                if (canBuild[i] == 0) {
                    pq.add(i);
                }
            }

            int answer = 0;

            while (!pq.isEmpty()) {
                int current = pq.poll();
                answer += delay[current];
                if (current == w){
                    break;
                }

                for(int s: pq.toArray(new Integer[0])){
                    delay[s] -= delay[current];
                }

                delay[current] = 0;

                for (int a : list.get(current)) {
                    canBuild[a]--;
                    if (canBuild[a] == 0) {
                        pq.add(a);
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}

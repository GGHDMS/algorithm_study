import java.util.*;
import java.io.*;

public class Baek1068 {

    static List<List<Integer>> tree = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, t;

    static int root = 0;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) {
                root = i;
                continue;
            }
            tree.get(a).add(i);
        }

        t = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        int answer = 0;

        if (root != t) {
            dq.add(root);
        }
        while (!dq.isEmpty()) {
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                int current = dq.poll();

                if (tree.get(current).size() == 0) {
                    answer++;
                } else {
                    int cSize = tree.get(current).size();
                    for (int next : tree.get(current)) {
                        if (next == t) {
                            if (cSize == 1) {
                                answer++;
                                break;
                            }
                            continue;
                        }
                        dq.add(next);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

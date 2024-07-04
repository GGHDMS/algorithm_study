import java.util.*;
import java.io.*;

public class Baek1043 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;

    static Set<Integer> know = new HashSet<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p; i++) {
            know.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        boolean[] visited = new boolean[m];
        boolean updated = true;

        while (updated) {
            updated = false;
            for (int i = 0; i < m; i++) {
                if (visited[i]) continue;

                List<Integer> party = parties.get(i);
                boolean knowsTruth = false;
                for (int person : party) {
                    if (know.contains(person)) {
                        knowsTruth = true;
                        break;
                    }
                }

                if (knowsTruth) {
                    visited[i] = true;
                    updated = true;
                    know.addAll(party);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            for (int person : parties.get(i)) {
                if (know.contains(person)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
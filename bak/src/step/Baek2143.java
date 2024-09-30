import java.util.*;
import java.io.*;

public class Baek2143 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t;
    static int n, m;
    static long[] a;
    static long[] b;

    static long[] aSum;
    static long[] bSum;

    static List<Long> aList = new ArrayList<>();
    static List<Long> bList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        a = new long[n + 1];
        aSum = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            aSum[i] = a[i] + aSum[i - 1];
        }

        m = Integer.parseInt(br.readLine());

        b = new long[m + 1];
        bSum = new long[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= m; i++) {
            bSum[i] = b[i] + bSum[i - 1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                aList.add(aSum[j] - aSum[i]);
            }
        }

        for (int l = 0; l < m; l++) {
            for (int o = l + 1; o <= m; o++) {
                bList.add(bSum[o] - bSum[l]);
            }
        }

        Collections.sort(aList);
        Collections.sort(bList, Comparator.reverseOrder());

        int ap = 0;
        int bp = 0;

        long answer = 0;

        while (true) {
            long currentA = aList.get(ap);
            long target = t - currentA;

            if (target == bList.get(bp)) {
                long aCount = 0;
                long bCount = 0;
                while (ap < aList.size() && aList.get(ap) == currentA) {
                    ap++;
                    aCount++;
                }

                while (bp < bList.size() && bList.get(bp) == target) {
                    bp++;
                    bCount++;
                }
                answer += aCount * bCount;
            } else if (target < bList.get(bp)) {
                bp++;
            } else {
                ap++;
            }

            if (ap >= aList.size() || bp >= bList.size()) {
                break;
            }
        }
        System.out.println(answer);
    }
}

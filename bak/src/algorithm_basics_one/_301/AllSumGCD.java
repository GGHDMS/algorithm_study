package algorithm_basics_one._301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AllSumGCD {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int a = 0; a < k - 1; a++) {
                for (int b = a + 1; b < k; b++) {
                    if (arr[a] > arr[b]) {
                        sum += gcd(arr[a], arr[b]);
                    } else {
                        sum += gcd(arr[b], arr[a]);
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }


}

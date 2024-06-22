import java.io.*;

public class Baek1644 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    static boolean[] num = new boolean[4_000_001];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        int k = (int) Math.sqrt(4_000_000);

        num[0] = true;
        num[1] = true;
        for (int i = 2; i <= k; i++) {
            for (int j = i * 2; j <= 4_000_000; j += i) {
                num[j] = true;
            }
        }

        int i = 0;
        int j = 0;

        int current = 0;
        int answer = 0;
        while (j <= n && i <= 4_000_000) {
            // System.out.println(i + " " + j + " " + current + " " + answer);
            if (num[i]) {
                i++;
                continue;
            }

            current += i;

            if (current == n) {
                answer++;
            }

            while (current >= n) {
                if (num[j++]) {
                    continue;
                }

                current -= (j - 1);
                if (current == n) {
                    answer++;
                }
            }
            i++;
        }

        System.out.println(answer);

    }
}

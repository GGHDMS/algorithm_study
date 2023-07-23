package algorithm_basics_one._301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllGoldbach {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[1000001];
        check[0] = true;
        check[1] = true;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            for (int j = i * i; j <= 1000000; j += i) {
                check[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            int t = 0;
            for (int j = 2; j <= k / 2; j++) {
                if (!check[j] && !check[k - j]) {
                    t++;
                }
            }
            System.out.println(t);
        }
    }
}

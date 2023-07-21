package algorithm_basics_one._300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[1000001];
        int n;
        check[0] = true;
        check[1] = true;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            for (int j = i * i; j <= 1000000; j += i) {
                check[j] = true;
            }
        }

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 3; i <= n / 2; i += 2) {
                if (!check[i] && !check[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    break;
                }
            }
        }
    }

}

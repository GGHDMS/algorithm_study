package algorithm_basics_one._300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumber {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            answer += isPrime(num);
        }
        System.out.println(answer);
    }

    public static int isPrime(int num) {
        if (num == 1) {
            return 0;
        } else if (num == 2) {
            return 1;
        } else if (num % 2 == 0) {
            return 0;
        } else {
            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }
}

import java.util.*;
import java.io.*;

public class Baek1111 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println("A");
            return;
        } else if (n == 2) {
            if (arr[0] == arr[1]) {
                System.out.println(arr[0]);
            } else {
                System.out.println("A");
            }
            return;
        }

        int a, b;

        if (arr[0] == arr[1]) {
            a = 0;
        } else {
            a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
        }

        b = arr[1] - arr[0] * a;

        for (int i = 0; i < n - 1; i++) {
            if (a * arr[i] + b != arr[i + 1]) {
                System.out.println("B");
                return;
            }
        }

        System.out.println(a * arr[n - 1] + b);
    }
}

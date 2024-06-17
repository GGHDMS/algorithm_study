import java.util.*;
import java.io.*;

public class Baek1806 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, s;
    static int[] array;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;

        int sum = 0;

        while (i != n) {
            sum += array[i];

            while (sum >= s) {
                answer = Math.min(i - j + 1, answer);
                sum -= array[j++];
            }
            
            i++;
        }

        while (sum >= s) {
            answer = Math.min(i - j + 1, answer);
            sum -= array[j++];
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}

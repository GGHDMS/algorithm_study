import java.util.*;
import java.io.*;

public class Baek2805 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int len = arr.length;
        int answer = arr[len - 1];

        int total = 0;
        int temp = 0;
        int i = len - 1;
        boolean flag = true;
        while (answer >= 0) {
            while (flag && arr[i] > answer && i >= 0) {
                temp++;
                i--;

                if(i < 0){
                    i = 0;
                    flag = false;
                }
            }

            total += temp;

            if (total >= m) {
                break;
            }
            answer--;
        }

        System.out.println(answer);
    }

}

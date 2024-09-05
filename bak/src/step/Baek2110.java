import java.util.*;
import java.io.*;

public class Baek2110 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, c;
    static int[] arr;
    static int min = 1, max;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        max = arr[arr.length - 1] - arr[0] + 1;

        while (min < max) {
            int pivot = min + ((max - min) / 2);

            if (canInstall(pivot) < c) {
                max = pivot;
            } else {
                min = pivot + 1;
            }

        }

        System.out.println(min - 1);

    }

    static int canInstall(int pivot) {
        int count = 1;
        int lastLocate = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - lastLocate >= pivot) {
                count++;
                lastLocate = arr[i];
            }

        }

        return count;
    }
}

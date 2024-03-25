import java.util.*;
import java.io.*;

public class Baek24060 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[] array;
    static int answerIndex;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, n - 1);
        System.out.println(answer);
    }

    public static void merge_sort(int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = (end + start) / 2;

        merge_sort(start, temp);
        merge_sort(temp + 1, end);
        merge(start, temp, end);
    }

    public static void merge(int start, int temp, int end) {
        int i = start;
        int j = temp + 1;
        int t = 0;
        int[] tArray = new int[end - start + 1];

        while (i <= temp && j <= end) {
            if (array[i] > array[j]) {
                tArray[t++] = array[j++];
            } else {
                tArray[t++] = array[i++];
            }
        }

        while (i <= temp) {
            tArray[t++] = array[i++];
        }

        while (j <= end) {
            tArray[t++] = array[j++];
        }

        i = 0;
        for (int s = start; s <= end; s++) {
            array[s] = tArray[i++];
            if(k == ++answerIndex){
                answer = array[s];
            }
        }
    }
}

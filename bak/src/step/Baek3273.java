import java.util.*;
import java.io.*;

public class Baek3273 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, x;
    static int[] array;

    public static void main(String[] args) throws Exception {
        int answer = 0;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int i = 0;
        int j = n - 1;

        while (i != j) {
            int temp = array[i] + array[j];
            if (temp == x) {
                answer++;
                j--;
            } else if(temp > x){
                j--;
            } else {
                i++;
            }
        }
        
        System.out.println(answer);
    }
}

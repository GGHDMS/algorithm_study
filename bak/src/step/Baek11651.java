import java.util.*;
import java.io.*;

public class Baek11651 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] array;
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        array = new int[n][2];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int[] i : array) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}

import java.util.*;
import java.io.*;

public class Baek1004 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t;
    static int n;

    public static void main(String[] args) throws Exception {

        t = Integer.parseInt(br.readLine());

        for (int temp = 0; temp < t; temp++) {

            int[] start = new int[2];
            int[] end = new int[2];

            st = new StringTokenizer(br.readLine());

            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            n = Integer.parseInt(br.readLine());

            int answer = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean sDistance = false;
                boolean eDistance = false;

                sDistance = Math.sqrt(Math.pow(start[0] - x, 2) + Math.pow(start[1] - y, 2)) < r;
                eDistance = Math.sqrt(Math.pow(end[0] - x, 2) + Math.pow(end[1] - y, 2)) < r;

                if (sDistance && eDistance) {
                    continue;
                } else if (sDistance || eDistance) {
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }
}

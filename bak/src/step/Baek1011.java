import java.util.*;
import java.io.*;

public class Baek1011 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int term = Integer.parseInt(br.readLine());

        for (int g = 0; g < term; g++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int distance = b - a;
            int max = (int) Math.sqrt(distance);

            if(max == Math.sqrt(distance)) {
                System.out.println((2 * max - 1));
            }
            else if(distance <= max * max + max) {
                System.out.println(2 * max);
            }
            else {
                System.out.println(2 * max + 1);
            }

        }

    }

}

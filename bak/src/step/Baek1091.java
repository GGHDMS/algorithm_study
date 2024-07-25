import java.io.*;
import java.util.*;

public class Baek1091 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] p;
    static int[] s;
    static int[] card;

    public static void main(String[] agrs) throws Exception {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        p = new int[n];
        s = new int[n];
        card = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            card[i] = p[i];
        }

        int answer = 0;
        while (true) {

            boolean finished = true;
            for (int i = 0; i < n; i += 3) {
                if (card[i] != 0 || card[i + 1] != 1 || card[i + 2] != 2) {
                    finished = false;
                    break;
                }
            }

            if (finished) {
                break;
            }

            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[s[i]] = card[i];
            }

            card = temp;
            answer++;

            int i=0;
            for (; i < n; i++) {
                if (card[i] != p[i]) {
                    break;
                }
            }
            if(i == n){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(answer);

    }

}

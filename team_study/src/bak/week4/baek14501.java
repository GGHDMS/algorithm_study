package bak.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14501 {

    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] t;
    static int[] p;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        init();
        start();

        System.out.println(answer[n]);
    }



    public static void start() {
        for (int i = 1; i <= n; i++) {
            answer[i] = answer[i - 1];
            for (int j = i; j >= 1; j--) {
                if (i - j + 1 == t[j]) {
                    answer[i] = Math.max(answer[i], answer[j - 1] + p[j]);
                }
            }
        }
    }


    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        t = new int[n + 1];
        p = new int[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
    }
}

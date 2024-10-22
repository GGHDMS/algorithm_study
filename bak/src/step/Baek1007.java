import java.util.*;
import java.io.*;

public class Baek1007 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int t, n;
    static int[][] arr;
    static double answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            answer = Double.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n];
            combination(n / 2, 0);
            bw.write(String.valueOf(answer + "\n"));
        }
        bw.flush();
    }

    static void combination(int count, int index) {
        if (count == 0) {
            answer = Math.min(answer, vector());
        } else {
            for (int i = index; i < n; i++) {
                visited[i] = true;
                combination(count - 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static double vector() {
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                x += arr[i][0];
                y += arr[i][1];
            } else {
                x -= arr[i][0];
                y -= arr[i][1];
            }
        }

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}

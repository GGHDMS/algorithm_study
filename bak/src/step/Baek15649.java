import java.util.*;
import java.io.*;

public class Baek15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] array;

    static int[] temp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n + 1];

        temp = new int[m + 1];
        visited = new boolean[n + 1];

        int j = 1;
        for (int i = 1; i <= n; i++) {
            array[i] = j++;
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            temp[1] = i;
            dfs(2);
            visited[i] = false;
        }

        System.out.println(sb);
    }

    static void dfs(int index) {
        if (index > m) {
            for (int i = 1; i <= m; i++) {
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            temp[index] = i;
            dfs(index + 1);
            visited[i] = false;
        }
    }
}

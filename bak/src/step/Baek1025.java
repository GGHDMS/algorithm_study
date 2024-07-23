import java.util.*;
import java.io.*;

public class Baek1025 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws Exception {
        int answer = -1;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int tempN = -n; tempN < n; tempN++) {
                    for (int tempM = -m; tempM < m; tempM++) {
                        if(tempN == 0 && tempM == 0){
                            continue;
                        }
                        int cI = i;
                        int cJ = j;
                        int sum = 0;
                        while (true) {
                            sum *= 10;
                            sum += map[cI][cJ];
 
                            int t = (int) Math.sqrt(sum);
                            if (t * t == sum) {
                                answer = Math.max(answer, sum);
                            }

                            if (0 > cI + tempN || cI + tempN >= n) {
                                break;
                            }
                            cI += tempN;

                            if (0 > cJ + tempM || cJ + tempM >= m) {
                                break;
                            }
                            cJ += tempM;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

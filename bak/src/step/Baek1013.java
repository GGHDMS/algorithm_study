import java.io.*;

public class Baek1013 {

    // (100+1+ | 01)+
    // 3
    // 10010111
    // 011000100110001
    // 0110001011001
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    static int[][] state = new int[][] { { 7, 1 }, { 2, 8 }, { 3, 8 }, { 3, 4 }, { 7, 5 }, { 6, 5 }, {3, 0}, {8, 0}, { 8, 8 } };

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int current = 0;

            for (char c : s.toCharArray()) {
                current = state[current][c - '0'];
            }

            if (current == 0 || current == 4 || current == 5) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}

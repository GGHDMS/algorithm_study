import java.util.*;
import java.io.*;

public class Baek1655 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static PriorityQueue<Integer> big = new PriorityQueue<>();

    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(br.readLine());
            return;
        }

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if (a > b) {
            big.add(a);
            sb.append(a).append("\n");
            small.add(b);
            sb.append(b).append("\n");
        } else {
            big.add(b);
            sb.append(a).append("\n");
            small.add(a);
            sb.append(a).append("\n");
        }

        for (int i = 2; i < n; i++) {
            int c = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                int s = small.poll();
                if( s > c){
                    small.add(s);
                    small.add(c);
                } else {
                    small.add(s);
                    int cb = big.poll();
                    
                    if(cb > c){
                        big.add(cb);                       
                        small.add(c);
                    } else {
                        big.add(c);                       
                        small.add(cb);
                    }
                }
            } else {
                int s = small.poll();
                if( s > c){
                    big.add(s);
                    small.add(c);
                } else {
                    small.add(s);
                    big.add(c);
                }
            }
            sb.append(small.peek()).append("\n");

        }

        System.out.println(sb);
    }
}

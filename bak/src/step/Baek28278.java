import java.util.*;
import java.io.*;

public class Baek28278 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Deque<Integer> deque = new ArrayDeque<>();
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.removeLast()).append("\n");
                    }
                    break;
                case 3:
                    sb.append(deque.size()).append("\n");
                    break;
                case 4:
                    if(deque.isEmpty()){
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case 5:
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
            }
        }
        System.out.println(sb);
    }
}

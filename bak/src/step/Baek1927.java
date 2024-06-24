import java.util.*;
import java.io.*;

public class Baek1927 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        return o1 - o2;
    });

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            if(k == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                } else{
                    sb.append(pq.poll()).append("\n");
                }

            } else{
                pq.add(k);
            }
        }

        System.out.println(sb);

    }
}

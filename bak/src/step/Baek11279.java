import java.io.*;
import java.util.*;

public class Baek11279 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine());
            if(k != 0){
                pq.offer(k);
                continue;
            }
            if(pq.isEmpty()){
                sb.append(0).append("\n");
                continue;
            }
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class Baek1715 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(pq.size() != 1){
            int temp =  pq.poll() + pq.poll();
            answer += temp;
            pq.add(temp);
        }

        System.out.println(answer);
    }
}

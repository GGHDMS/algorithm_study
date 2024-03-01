import java.io.*;
import java.util.*;

public class Baek11047 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static Integer[] coin;
    static int answer = 0;


    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new Integer[n];

        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin, Collections.reverseOrder());


        for(int i=0;i<n;i++){
            if(k == 0) {
                break;
            }          

            if ( k - coin[i] < 0){
                continue;
            } 
            do{
                k = k - coin[i];
                answer++;
            } while(k - coin[i] >= 0 );
        }

        System.out.println(answer);

    }
    
}

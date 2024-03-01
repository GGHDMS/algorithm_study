import java.io.*;
import java.util.*;

public class Baek1931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> list;


    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int[] a = new int[2];

            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());

            list.add(a);
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int finish = 0;
        int answer= 0;

        for(int[] i : list){
            if(i[0] >= finish){
                finish = i[1];
                answer ++;
            }
        }

        System.out.println(answer);
    }
}

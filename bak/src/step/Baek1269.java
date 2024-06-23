import java.util.*;
import java.io.*;

public class Baek1269 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Set<Integer> a = new HashSet<>();
    static Set<Integer> b = new HashSet<>();

    public static void main(String[] args) throws Exception {
        int i, j;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        i = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < i; k++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < j; k++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> temp = new HashSet<>(a);

        temp.removeAll(b);
        answer += temp.size();

        temp = new HashSet<>(b);
        
        temp.removeAll(a);
        answer += temp.size();

        System.out.println(answer);
    }
}

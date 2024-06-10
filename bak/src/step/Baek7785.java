import java.util.*;
import java.io.*;

public class Baek7785 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (b.equals("enter")) {
                set.add(a);
            } else {
                set.remove(a);
            }
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, Comparator.reverseOrder());
        for(String s : list){
            System.out.println(s);
        }

    }
}

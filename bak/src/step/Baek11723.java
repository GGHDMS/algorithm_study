import java.util.*;
import java.io.*;

public class Baek11723 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[20];
        for (int i = 0; i < 20; i++) {
            array[i] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(st.nextToken()))) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "toggle":
                    int k = Integer.parseInt(st.nextToken());
                    if (set.contains(k)) {
                        set.remove(k);
                    } else {
                        set.add(k);
                    }
                    break;
                case "all":
                    set = new HashSet <>(Arrays.asList(array));
                    break;
                case "empty":
                    set.clear();
            }
        }
        System.out.println(sb);
    }
}

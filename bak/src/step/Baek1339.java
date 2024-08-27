import java.util.*;
import java.io.*;

public class Baek1339 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            int len = s.length();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, len - 1));
                len--;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
        
        int answer = 0;
        int num = 9;
        for(char c : list){
            answer += map.get(c) * num;
            num--;
        }

        System.out.println(answer);

    }
}

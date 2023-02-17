import java.util.HashMap;
import java.util.Scanner;

public class AnagramAll {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char c : str2.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            map2.put(str1.charAt(i), map2.getOrDefault(str1.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = str2.length() - 1; rt < str1.length(); rt++) {
            map2.put(str1.charAt(rt), map2.getOrDefault(str1.charAt(rt), 0) + 1);
            if (map1.equals(map2)) {
                answer++;
            }
            map2.put(str1.charAt(lt), map2.get(str1.charAt(lt)) - 1);
            if (map2.get(str1.charAt(lt)) == 0) {
                map2.remove(str1.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        AnagramAll t = new AnagramAll();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(t.solution(str1, str2));
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class ClassMonitor {
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Character c : hashMap.keySet()) {
            if (max < hashMap.get(c)) {
                max = hashMap.get(c);
                answer = c;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ClassMonitor t = new ClassMonitor();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(t.solution(n, str));
    }
}

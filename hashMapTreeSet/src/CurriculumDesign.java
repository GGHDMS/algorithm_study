import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public String solution(String str1, String str2) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : str2.toCharArray()) {
            queue.offer(c);
        }

        for (char c : str1.toCharArray()) {
            if (!queue.contains(c)) {
                return "NO";
            }
            while (queue.poll() != c) ;
        }
        return "YES";
    }

    public static void main(String[] args) {
        CurriculumDesign t = new CurriculumDesign();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(t.solution(str1, str2));
    }
}

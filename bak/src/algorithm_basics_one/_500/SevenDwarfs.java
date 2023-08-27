package algorithm_basics_one._500;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarfs {
    static int[] array = new int[9];
    static boolean[] visited = new boolean[9];
    static boolean check = false;
    static int[] answer = new int[7];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        dfs(0, 0);  // Start from the 0th index and n=0

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static void dfs(int idx, int n){
        if(check){
            return;
        }

        if(n == 7){
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if (visited[i]) {
                    sum += array[i];
                }
            }

            if (sum == 100) {
                check = true;
                int k = 0;
                for (int i = 0; i < 9; i++) {
                    if (visited[i]) {
                        answer[k++] = array[i];
                    }
                }
                return;
            }
            return;
        }

        for (int i = idx; i < 9; i++) {  // Start from idx to avoid duplicate combinations
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, n + 1);  // Move to the next index and increment n
                visited[i] = false;
            }
        }
    }
}

import java.util.*;

public class CommonElement {
    public List<Integer> solution(int n1, int n2, int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n1x = 0, n2x = 0;
        while (n1x < n1 && n2x < n2) {
            if(arr1[n1x] < arr2[n2x]){
                n1x++;
            } else if(arr1[n1x] > arr2[n2x]){
                n2x++;
            }
            else {
                answer.add(arr1[n1x++]);
                n2x++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CommonElement t = new CommonElement();
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }
        arr1 = Arrays.stream(arr1).sorted().toArray();
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        arr2 = Arrays.stream(arr2).sorted().toArray();
        List<Integer> solution = t.solution(n1, n2, arr1, arr2);
        for (Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}

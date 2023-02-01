import java.util.Scanner;

public class TwoArraysSum {
    public int[] solution(int n1, int n2, int[] arr1, int[] arr2) {
        int[] answer = new int[n1+n2];
        int i=0;
        int n1x=0, n2x=0;
        while (n1x<n1 && n2x<n2){
            if(arr1[n1x] <= arr2[n2x]){
                answer[i++] = arr1[n1x++];
            }
            else {
                answer[i++] = arr2[n2x++];
            }
        }
        while (n1x<n1){
            answer[i++] = arr1[n1x++];
        }
        while (n2x<n2){
            answer[i++] = arr2[n2x++];
        }
        return answer;
    }

    public static void main(String[] args) {
        TwoArraysSum t = new TwoArraysSum();
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        int[] solution = t.solution(n1, n2, arr1, arr2);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

import java.util.Scanner;

public class RockPaperScissors {
    public String solution(int n, int[] arr1, int[] arr2){
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<n;i++){
            if(arr1[i] == arr2[i])
                answer.append("D");
            else if ((arr1[i] ==1 && arr2[i] == 3) ||(arr1[i] ==2 && arr2[i] == 1) || (arr1[i] ==3 && arr2[i] == 2))
                answer.append("A");
            else
                answer.append("B");
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        RockPaperScissors t = new RockPaperScissors();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0; i< n ;i++){
            arr1[i] = scanner.nextInt();
        }

        for(int i=0; i< n ;i++){
            arr2[i] = scanner.nextInt();
        }
        for (char c : t.solution(n, arr1, arr2).toCharArray()) {
            System.out.println(c);
        }
    }
}


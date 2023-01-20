import java.util.Scanner;

class ShortestDistanceChar {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];
        int p = 1000;
        for(int i =0;i <str.length(); i++){
            if (str.charAt(i) == c){
                p=0;
                answer[i] = p;
            }
            else {
                answer[i] = ++p;
            }
        }
        p = 1000;
        for(int i = str.length()-1;i >=0; i--){
            if (str.charAt(i) == c){
                p=0;
            }
            else {
                p++;
//                if (answer[i] > p)
//                    answer[i] = p;
                 answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ShortestDistanceChar t = new ShortestDistanceChar();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        for (int i : t.solution(str, c)) {
            System.out.print(i+" ");
        }
    }
}

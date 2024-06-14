import java.io.*;

public class Baek11729 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());

        hanoi(1, 3, 2, n);

        System.out.println(answer);
        System.out.println(sb);
    }

    static void hanoi(int start, int target, int temp, int m){
        if(m == 1){
            answer++;
            sb.append(start).append(" ").append(target).append("\n");
            return;
        }

        hanoi(start, temp, target, m - 1);
        sb.append(start).append(" ").append(target).append("\n");
        answer++;
        hanoi(temp, target, start, m - 1);
    }
    }
import java.io.*;

public class Bak1436 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws Exception{

        n = Integer.parseInt(br.readLine());

        int i = 666;
        while(true){
            if(String.valueOf(i).contains("666")){
                n --;
            }

            if(n == 0){
                System.out.println(i);
                break;
            }

            i++;
        }

    }

    
}
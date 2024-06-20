import java.util.*;
import java.io.*;

public class Baek2908 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        String a = new StringBuilder(st.nextToken()).reverse().toString();
        String b = new StringBuilder(st.nextToken()).reverse().toString();

        if(Integer.parseInt(a) < Integer.parseInt(b)){
            System.out.println(b);
        } else{
            System.out.println(a);
        }
    }
}

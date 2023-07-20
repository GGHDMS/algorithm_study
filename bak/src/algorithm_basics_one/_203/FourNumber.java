package algorithm_basics_one._203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourNumber {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken() + st.nextToken();
        String s2 = st.nextToken() + st.nextToken();

        System.out.println(Long.parseLong(s1) + Long.parseLong(s2));
    }
}

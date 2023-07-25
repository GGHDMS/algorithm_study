package algorithm_basics_one._303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ss = br.readLine();
        int num = Integer.parseInt(ss.substring(0, ss.indexOf(" ")));
        int bin = Integer.parseInt(ss.substring(ss.indexOf(" ") + 1));

        System.out.println(Integer.toString(num, bin).toUpperCase());
    }
}
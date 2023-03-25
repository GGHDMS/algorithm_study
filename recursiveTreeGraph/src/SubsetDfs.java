import java.util.Scanner;

public class SubsetDfs {
    static int n;
    static int[] ch;
    public void DFS(int l) {
        if (l == n + 1) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (ch[i] != 0) {
                    tmp.append(i).append(" ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp.toString());
            }
            return;
        }
        ch[l] = 1;
        DFS(l+1);
        ch[l] = 0;
        DFS(l+1);
    }

    public static void main(String[] args) {
        SubsetDfs t = new SubsetDfs();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ch = new int[n + 1];
        t.DFS(1);
    }


}

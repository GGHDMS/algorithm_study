import java.util.Scanner;

public class UnionAndFind {
    static int[] check;

    public static int find(int x) {
        if (x == check[x]) {
            return check[x];
        } else {
            return check[x] = find(check[x]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            check[fa] = fb;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        check = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            check[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a, b);
        }

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (find(a) == find(b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

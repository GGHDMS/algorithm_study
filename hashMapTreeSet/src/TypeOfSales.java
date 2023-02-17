import java.util.*;

public class TypeOfSales {
    public List<Integer> solution(int n, int k, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            list.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0){
                map.remove(arr[lt]);
            }
            lt++;
        }
        return list;
    }

    public static void main(String[] args) {
        TypeOfSales t = new TypeOfSales();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        List<Integer> solution = t.solution(n, k, arr);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
    }
}

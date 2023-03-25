public class ShortestRouteDFS { //BFS 문제임 -> 최단 경로
    int answer = Integer.MAX_VALUE;

    public int DFS(Node root, int n) {
        if (root.lt == null && root.rt == null) {
            return n;
        } else {
            return Math.min(DFS(root.lt, n + 1), DFS(root.rt, n + 1));
        }
    }


    public static void main(String[] args) {
        ShortestRouteDFS t = new ShortestRouteDFS();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(t.DFS(root, 0));
    }

    public static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
}

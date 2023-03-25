import java.util.LinkedList;
import java.util.Queue;

public class ShortestRouteBfs {
    public int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();

        int result = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Node poll = queue.poll();
                if (poll.lt == null && poll.rt == null) {
                    return result;
                }
                if (poll.lt != null) {
                    queue.offer(poll.lt);
                }
                if (poll.rt != null) {
                    queue.offer(poll.rt);
                }
            }
            result++;
        }
        return result;
    }


    public static void main(String[] args) {
        ShortestRouteBfs t = new ShortestRouteBfs();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(t.bfs(root));
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

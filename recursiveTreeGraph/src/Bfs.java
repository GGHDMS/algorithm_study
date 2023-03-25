import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    Node root;
    static Queue<Node> queue = new LinkedList<>();

    public void BFS(Node root) {
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.lt != null) {
                queue.offer(node.lt);
            }
            if (node.rt != null) {
                queue.offer(node.rt);
            }
        }
    }


    public static void main(String[] args) {
        Bfs tree = new Bfs();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
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

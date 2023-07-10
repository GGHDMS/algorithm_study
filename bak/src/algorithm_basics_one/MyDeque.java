package algorithm_basics_one;

import java.io.*;
import java.util.StringTokenizer;

public class MyDeque {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        De de = new De();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    de.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    de.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(de.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(de.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(de.size()).append("\n");
                    break;
                case "empty":
                    if (de.empty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    sb.append(de.front()).append("\n");
                    break;
                case "back":
                    sb.append(de.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class De {
        int size;
        Node head;
        Node tail;

        public De() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        public void push_front(int n) {
            Node node = new Node(n);
            if (size == 0) {
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
            }
            head = node;
            size++;
        }

        public void push_back(int n) {
            Node node = new Node(n);
            if (size == 0) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public int pop_front() {
            if (size == 0) {
                return -1;
            } else if (size == 1) {
                int data = head.data;
                head = null;
                tail = null;
                size--;
                return data;
            } else {
                int data = head.data;
                head = head.next;
                head.prev = null;
                size--;
                return data;
            }
        }

        public int pop_back() {
            if (size == 0) {
                return -1;
            } else if (size == 1) {
                int data = tail.data;
                head = null;
                tail = null;
                size--;
                return data;
            } else {
                int data = tail.data;
                tail = tail.prev;
                tail.next = null;
                size--;
                return data;
            }
        }

        public boolean empty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return head.data;
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return tail.data;
        }
    }

    public static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

}


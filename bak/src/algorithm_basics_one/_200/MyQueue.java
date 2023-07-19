package algorithm_basics_one._200;

import java.io.*;
import java.util.StringTokenizer;

public class MyQueue {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Qu qu = new Qu(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    qu.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(String.valueOf(qu.pop()) + "\n");
                    break;
                case "size":
                    bw.write(String.valueOf(qu.size) + "\n");
                    break;
                case "empty":
                    if (qu.empty()) {
                        bw.write(String.valueOf(1) + "\n");
                    } else {
                        bw.write(String.valueOf(0) + "\n");
                    }
                    break;
                case "front":
                    bw.write(String.valueOf(qu.front()) + "\n");
                    break;
                case "back":
                    bw.write(String.valueOf(qu.back()) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

    public static class Qu {
        int bottom;
        int top;
        int size;
        int[] qu;

        public Qu(int size) {
            bottom = 0;
            top = -1;
            this.size = 0;
            qu = new int[size];
        }

        public void push(int n) {
            qu[++top] = n;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            size--;
            return qu[bottom++];
        }

        public int size() {
            return size;
        }

        public boolean empty() {
            return size == 0;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return qu[bottom];
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return qu[top];
        }
    }

}

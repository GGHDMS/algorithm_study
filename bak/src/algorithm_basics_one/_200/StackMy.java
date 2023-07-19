package algorithm_basics_one._200;

import java.io.*;
import java.util.StringTokenizer;

public class StackMy {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        MyStack myStack = new MyStack(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String s = token.nextToken();
            switch (s) {
                case "push":
                    myStack.push(Integer.parseInt(token.nextToken()));
                    break;
                case "pop":
                    System.out.println(myStack.pop());
                    break;
                case "size":
                    System.out.println(myStack.size);
                    break;
                case "empty":
                    if (myStack.empty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    System.out.println(myStack.top());
                    break;
            }
        }
    }

    public static class MyStack {
        private int top;
        private int size;
        private int[] stack;

        public MyStack(int size) {
            this.top = -1;
            this.size = 0;
            this.stack = new int[size];
        }

        public void push(int n) {
            size++;
            stack[++top] = n;
        }

        public int pop() {
            if (this.empty()) {
                return -1;
            }
            size--;
            return stack[top--];
        }

        public int size() {
            return size;
        }

        public boolean empty() {
            return size == 0;
        }

        public int top() {
            if (this.empty()) {
                return -1;
            }
            return stack[top];
        }
    }
}

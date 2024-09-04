package backjoon.stack;

import java.io.*;
import java.util.Stack;

public class Stack9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] strs = new String[T];

        for (int i = 0; i < T; i++) {
            strs[i] = br.readLine();
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < T; i++) {

            char[] chars = strs[i].toCharArray();

            for (char c : chars) {
                if (c == '(' || stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

            stack.clear();
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

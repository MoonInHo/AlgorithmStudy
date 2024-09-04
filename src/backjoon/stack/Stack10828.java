package backjoon.stack;

import java.io.*;
import java.util.ArrayDeque;

public class Stack10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];

        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String str : strs) {

            int result = 0;

            switch (str) {
                case "pop":
                    result = stack.isEmpty() ? -1 : stack.pop();
                    break;
                case "size":
                    result = stack.size();
                    break;
                case "empty":
                    result = stack.isEmpty() ? 1 : 0;
                    break;
                case "top":
                    result = stack.isEmpty() ? -1 : stack.peek();
                    break;
                default:
                    stack.push(Integer.parseInt(str.substring(5)));
            }
            if (!str.startsWith("push")) {
                sb.append(result).append("\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

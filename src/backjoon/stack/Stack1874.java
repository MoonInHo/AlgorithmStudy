package backjoon.stack;

import java.io.*;
import java.util.ArrayDeque;

public class Stack1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int lastValue = 0;

        for (int i = 0; i < N; i++) {

            int value = Integer.parseInt(br.readLine());

            if (lastValue < value) {
                for (int j = lastValue + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                lastValue = value;
            } else {
                if (stack.peek() != value) {
                    bw.write("NO");
                    bw.flush();
                    return;
                }
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

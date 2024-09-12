package backjoon.queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Queue1158 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            if (queue.size() > 1) {
                sb.append(queue.poll()).append(", ");
            } else {
                sb.append(queue.poll());
            }
        }
        sb.append(">");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
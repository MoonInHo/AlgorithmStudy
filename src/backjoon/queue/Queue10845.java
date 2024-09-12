package backjoon.queue;

import java.io.*;
import java.util.ArrayDeque;

public class Queue10845 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            String command = br.readLine();

            switch (command) {
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
                default:
                    queue.add(command.substring(5));
                    break;
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

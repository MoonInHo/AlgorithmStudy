package backjoon.queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Queue14713 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayDeque<String>> list = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < N; i++) {

            ArrayDeque<String> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                queue.add(st.nextToken());
            }
            list.add(queue);
            count += queue.size();
        }

        String L = br.readLine();

        String[] arr = L.split(" ");

        if (count != arr.length) {
            System.out.println("Impossible");
            return;
        }

        for (String s : arr) {
            for (int j = 0; j < N; j++) {
                ArrayDeque<String> queue = list.get(j);
                if (!queue.isEmpty() && s.equals(queue.peek())) {
                    queue.poll();
                    break;
                }
                if (j == N - 1) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        System.out.println("Possible");
        br.close();
    }
}

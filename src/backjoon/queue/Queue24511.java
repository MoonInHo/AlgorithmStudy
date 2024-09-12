package backjoon.queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Queue24511 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dataStructures = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dataStructures[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> queuestack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (dataStructures[i] == 0) {
                queuestack.offer(x);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            queuestack.offerFirst(x);
            sb.append(queuestack.pollLast()).append(" ");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

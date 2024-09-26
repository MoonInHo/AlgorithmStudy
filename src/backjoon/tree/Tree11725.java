package backjoon.tree;

import java.io.*;
import java.util.*;

public class Tree11725 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        tree.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {

            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }
        boolean[] visited = new boolean[N + 1];
        int[] result = new int[N + 1];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {

            int i = queue.poll();

            for (int node : tree.get(i)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    result[node] = i;
                }
            }
        }

        for (int i : result) {
            if (i != 0) sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

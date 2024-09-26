package backjoon.tree;

import java.io.*;
import java.util.*;

public class Tree1967 {

    static List<Node>[] nodes;
    static boolean[] visited;
    static int result = 0;

    static class Node {

        int link;
        int weight;

        public Node(int link, int weight) {
            this.link = link;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        nodes = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[parentNode].add(new Node(childNode, weight));
            nodes[childNode].add(new Node(parentNode, weight));
        }


        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void dfs(int num, int weight) {
        for (Node node : nodes[num]) {
            if (!visited[node.link]) {
                visited[node.link] = true;
                dfs(node.link, weight + node.weight);
            }
        }
        result = Math.max(result, weight);
    }
}

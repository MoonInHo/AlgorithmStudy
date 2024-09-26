package backjoon.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree1167 {

    static ArrayList<Node>[] nodes;
    static boolean[] visited;
    static int result;

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

        for (int i = 0; i <= N; i++) {

        }
    }
}

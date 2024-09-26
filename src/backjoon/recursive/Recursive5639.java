package backjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive5639 {

    static StringBuilder sb = new StringBuilder();

    static class Node {

        int root;
        Node left, right;

        public Node(int root) {
            this.root = root;
        }

        public void insert(int node) {
            if (root > node) {
                if (left == null) left = new Node(node);
                else left.insert(node);
            } else {
                if (right == null) right = new Node(node);
                else right.insert(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String input = br.readLine();

            if(input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);

        System.out.println(sb);
        br.close();
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.root).append("\n");
    }
}

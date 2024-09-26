package backjoon.tree;

import java.io.*;
import java.util.StringTokenizer;

public class Tree1991 {

    private static final StringBuilder sb = new StringBuilder();
    private static final Node tree = new Node('A');

    static class Node {

        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            initTree(tree, root, left, right);
        }

        preOrder(tree);
        sb.append("\n");
        inOrder(tree);
        sb.append("\n");
        postOrder(tree);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void initTree(Node tree, char root, char left, char right) {
        if (tree.value == root) {
            tree.left = left == '.' ? null : new Node(left);
            tree.right = right == '.' ? null : new Node(right);
        } else {
            if (tree.left != null) initTree(tree.left, root, left, right);
            if (tree.right != null) initTree(tree.right, root, left, right);
        }
    }

    private static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}

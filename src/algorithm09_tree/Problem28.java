package algorithm09_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Problem28 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int infoSize = scanner.nextInt();
        int edgesSize = scanner.nextInt();

        int[] info = new int[infoSize];
        int[][] edges = new int[edgesSize][2];

        for (int i = 0; i < infoSize; i++) {
            info[i] = scanner.nextInt();
        }
        for (int i = 0; i < edgesSize; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(info, edges));
    }

    private static ArrayList<Integer>[] tree;

    public static int solution(int[] info, int[][] edges) {

        buildTree(info, edges);

        int answer = 0;

        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        while (!queue.isEmpty()) {

            Info now = queue.poll();

            answer = Math.max(answer, now.sheep);

            now.visited.addAll(tree[now.node]);

            for (Integer next : now.visited) {

                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                if (info[next] == 1) {
                    if (now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        return answer;
    }

    private static void buildTree(int[] info, int[][] edges) {

        tree = new ArrayList[info.length];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    private static class Info {

        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
}

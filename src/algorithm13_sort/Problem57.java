package algorithm13_sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem57 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int landSize= scanner.nextInt();
        int[][] land = new int[landSize][landSize];

        for (int i = 0; i < landSize; i++) {
            for (int j = 0; j < landSize; j++) {
                land[i][j] = scanner.nextInt();
            }
        }

        int height = scanner.nextInt();

        System.out.println(solution(land, height));
    }

    private static class Node {

        int i, j, cost;

        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    public static int solution(int[][] land, int height) {

        int answer = 0;
        int n = land.length;

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.i][now.j]) {
                continue;
            }

            visited[now.i][now.j] = true;
            answer += now.cost;

            for (int i = 0; i < 4; i++) {

                int ni = now.i + di[i];
                int nj = now.j + dj[i];

                if (!(0 <= ni && ni < n && 0 <= nj && nj < n)) {
                    continue;
                }

                int tempCost = Math.abs(land[now.i][now.j] - land[ni][nj]);
                int newCost = tempCost > height ? tempCost : 0;

                pq.add(new Node(ni, nj, newCost));
            }
        }
        return answer;
    }
}

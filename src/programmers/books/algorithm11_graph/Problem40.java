package programmers.books.algorithm11_graph;

import java.util.*;

public class Problem40 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int roadSize = scanner.nextInt();

        int[][] road = new int[roadSize][3];

        for (int i = 0; i < roadSize; i++) {
            for (int j = 0; j < 3; j++) {
                road[i][j] = scanner.nextInt();
            }
        }
        int K = scanner.nextInt();

        System.out.println(solution(N, road, K));
    }

    public static class Node {

        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int solution(int N, int[][] road, int K) {

        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }

        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (dist[now.dest] < now.cost) {
                continue;
            }

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}

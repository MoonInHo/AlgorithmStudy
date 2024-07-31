package algorithm11_graph;

import java.util.*;

public class Problem36 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int graphSize = scanner.nextInt();
        int[][] graph = new int[graphSize][3];

        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < 3; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int start = scanner.nextInt();
        int n = scanner.nextInt();

        int[] result = solution(graph, start, n);
        System.out.println(Arrays.toString(result));
    }

    private static class Node {

        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {

        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));

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

        return dist;
    }
}

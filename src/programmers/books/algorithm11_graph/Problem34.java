package programmers.books.algorithm11_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem34 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int graphSize = scanner.nextInt();
        int start = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] graph = new int[graphSize][2];

        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < 2; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int[] result = solution(graph, start, n);
        System.out.println(Arrays.toString(result));
    }

    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static int[] solution(int[][] graph, int start, int n) {

        adjList = new ArrayList[n + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);

        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

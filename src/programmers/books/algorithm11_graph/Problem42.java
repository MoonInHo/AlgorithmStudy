package programmers.books.algorithm11_graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem42 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int wiresSize = scanner.nextInt();

        int[][] wires = new int[wiresSize][2];
        for (int i = 0; i < wiresSize; i++) {
            for (int j = 0; j < 2; j++) {
                wires[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, wires));
    }

    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int N, answer;

    public static int solution(int n, int[][] wires) {

        N = n;
        answer = n - 1;

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        visited = new boolean[n + 1];
        dfs(1);
        return answer;
    }

    private static int dfs(int now) {

        visited[now] = true;
        int sum = 0;

        for (int next : adjList[now]) {
            if (!visited[next]) {
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                sum += cnt;
            }
        }
        return sum + 1;
    }
}

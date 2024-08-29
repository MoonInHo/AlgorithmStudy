package programmers.books.algorithm10_set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem33 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int costsSize = scanner.nextInt();

        int[][] costs = new int[costsSize][3];

        for (int i = 0; i < costsSize; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, costs));
    }

    private static int[] parent;

    public static int solution(int n, int[][] costs) {

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int edges = 0;

        for (int[] edge : costs) {
            if (edges == n - 1) {
                break;
            }
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        return answer;
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    private static int find(int x) {

        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}

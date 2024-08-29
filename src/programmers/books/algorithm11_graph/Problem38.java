package programmers.books.algorithm11_graph;

import java.util.Scanner;

public class Problem38 {

    /**
     * 풀이대로 수행해도 에러 발생
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int computersSize = scanner.nextInt();

        int[][] computers = new int[computersSize][computersSize];

        for (int i = 0; i < computersSize; i++) {
            for (int j = 0; j < computersSize; j++) {
                computers[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, computers));
    }

    private static boolean[] visit;
    private static int[][] computer;

    public static int solution(int n, int[][] computers) {

        int answer = 0;
        computer = computers;
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int now) {

        visit[now] = true;
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visit[now]) {
                dfs(i);
            }
        }
    }
}

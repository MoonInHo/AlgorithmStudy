package programmers.books.algorithm12_backtracking;

import java.util.Scanner;

public class Problem45 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int dungeonsSize = scanner.nextInt();

        int[][] dungeons = new int[dungeonsSize][2];

        for (int i = 0; i < dungeonsSize; i++) {
            for (int j = 0; j < 2; j++) {
                dungeons[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(k, dungeons));
    }

    private static int answer;
    private static int[][] Dungeons;
    private static boolean[] visited;

    private static void backtrack(int k, int cnt) {

        for (int i = 0; i < Dungeons.length; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {

        answer = 0;
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];

        backtrack(k, 0);
        return answer;
    }
}

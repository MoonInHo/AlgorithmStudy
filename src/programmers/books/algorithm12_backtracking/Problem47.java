package programmers.books.algorithm12_backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Problem47 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] info = new int[11];

        for (int i = 0; i < info.length; i++) {
            info[i] = scanner.nextInt();
        }
        int[] result = solution(n, info);
        System.out.println(Arrays.toString(result));
    }

    private static int max;
    private static int[] answer;
    private static int[] apeach;

    private static int getScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] + apeach[i] > 0) {
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }
        return score;
    }

    private static void calculateDiff(int[] ryan) {
        int score = getScore(ryan);
        if (max < score) {
            max = score;
            answer = ryan.clone();
        } else if (max > 0 && max == score) {
            for (int i = 10; i >= 0; i--) {
                if(answer[i] != ryan[i]) {
                    if (answer[i] < ryan[i]) {
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }

    private static void backtrack(int n, int idx, int[] ryan) {
        if (n == 0) {
            calculateDiff(ryan);
            return;
        }

        for (int i = idx; i <= 10; i++) {
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            backtrack(n - cnt, i + 1, ryan);
            ryan[i] = 0;
        }
    }

    public static int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        backtrack(n, 0, new int[11]);
        return max == 0 ? new int[]{-1} : answer;
    }
}

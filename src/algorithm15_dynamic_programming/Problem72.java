package algorithm15_dynamic_programming;

import java.util.Scanner;

public class Problem72 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int triangleSize = scanner.nextInt();
        int[][] triangle = new int[triangleSize][];

        for (int i = 0; i < triangleSize; i++) {

            triangle[i] = new int[i + 1];

            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {

        int n = triangle.length;
        int[][] dp = new int[n][n];

        System.arraycopy(triangle[n - 1], 0, dp[n - 1], 0, n);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}

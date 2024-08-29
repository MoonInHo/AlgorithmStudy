package programmers.books.algorithm15_dynamic_programming;

import java.util.Scanner;

public class Problem71 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }
        return dp[n];
    }
}

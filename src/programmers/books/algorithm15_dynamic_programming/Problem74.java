package programmers.books.algorithm15_dynamic_programming;

import java.util.Scanner;

public class Problem74 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int moneyLength = scanner.nextInt();
        int[] money = new int[moneyLength];

        for (int i = 0; i < moneyLength; i++) {
            money[i] = scanner.nextInt();
        }
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {

        int n = money.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = money[0];
        dp2[1] = money[0];

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        dp2[1] = money[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
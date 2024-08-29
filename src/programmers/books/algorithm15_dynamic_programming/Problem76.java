package programmers.books.algorithm15_dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem76 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int strsLength = scanner.nextInt();
        String[] strs = new String[strsLength];

        scanner.nextLine();

        for (int i = 0; i < strsLength; i++) {
            strs[i] = scanner.nextLine();
        }

        String t = scanner.nextLine();

        System.out.println(solution(strs, t));
    }

    private static final int INF = 20_001;

    public static int solution(String[] strs, String t) {

        int n = t.length(); // ❶ 타겟 문자열 t의 길이
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        HashSet<Integer> sizes = new HashSet<>();
        for (String str : strs) {
            sizes.add(str.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int size : sizes) {
                if (i - size >= 0) {
                    String sub = t.substring(i - size, i);
                    if (Arrays.asList(strs).contains(sub)) {
                        dp[i] = Math.min(dp[i], dp[i - size] + 1);
                    }
                }
            }
        }
        return dp[n] < INF ? dp[n] : -1;
    }
}

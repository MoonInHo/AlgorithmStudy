package algorithm15_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Problem68 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numsLength = scanner.nextInt();
        int[] nums = new int[numsLength];

        for (int i = 0; i < numsLength; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

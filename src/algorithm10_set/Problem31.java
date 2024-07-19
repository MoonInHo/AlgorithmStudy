package algorithm10_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem31 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numsSize = scanner.nextInt();
        int[] nums = new int[numsSize];

        for (int i = 0; i < numsSize; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {

        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        int n = nums.length;

        int k = n / 2;

        return Math.min(k, set.size());
    }
}

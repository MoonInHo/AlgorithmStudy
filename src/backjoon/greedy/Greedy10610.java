package backjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Greedy10610 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String N = scanner.nextLine();

        Character[] nums = new Character[N.length()];

        for (int i = 0; i < N.length(); i++) {
            nums[i] = N.charAt(i);
        }

        int sum = 0;

        for (char num : nums) {
            sum += num;
        }

        if (!N.contains("0") || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(nums, Collections.reverseOrder());
            System.out.println(Arrays.stream(nums).map(String::valueOf).collect(Collectors.joining()));
        }
    }
}

package algorithm13_sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem53 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();

        System.out.println(solution(n));
    }

    public static long solution(long n) {

        String[] digits = String.valueOf(n).split("");

        Arrays.sort(digits, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }
}

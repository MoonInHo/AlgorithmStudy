package programmers.books.algorithm16_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Problem81 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int tangerineLength = scanner.nextInt();
        int[] tangerine = new int[tangerineLength];

        for (int i = 0; i < tangerineLength; i++) {
            tangerine[i] = scanner.nextInt();
        }
        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> sortedCounts = new ArrayList<>(map.values());
        sortedCounts.sort(Collections.reverseOrder());

        int numTypes = 0;
        int countSum = 0;

        for (Integer count : sortedCounts) {
            countSum += count;
            numTypes++;
            if (countSum >= k) {
                break;
            }
        }
        return numTypes;
    }
}

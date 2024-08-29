package programmers.books.algorithm16_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem79 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dLength = scanner.nextInt();
        int[] d = new int[dLength];

        for (int i = 0; i < dLength; i++) {
            d[i] = scanner.nextInt();
        }

        int budget = scanner.nextInt();

        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {

        Arrays.sort(d);

        int count = 0;

        for (int amount : d) {
            if (budget < amount) break;
            budget -= amount;
            count++;
        }
        return budget >= 0 ? count : count - 1;
    }
}

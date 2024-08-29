package programmers.books.algorithm16_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem77 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amount = scanner.nextInt();

        System.out.println(Arrays.toString(solution(amount)));
    }

    public static int[] solution(int amount) {

        int[] coin = {100, 50, 10, 1};

        ArrayList<Integer> result = new ArrayList<>();

        for (int c : coin) {
            while (c <= amount) {
                result.add(c);
                amount -= c;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

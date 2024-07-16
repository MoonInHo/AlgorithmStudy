package algorithm07_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cards1Size = scanner.nextInt();
        int cards2Size = scanner.nextInt();

        String[] cards1 = new String[cards1Size];
        String[] cards2 = new String[cards2Size];
        String[] goal = new String[cards1Size + cards2Size];

        scanner.nextLine();

        for (int i = 0; i < cards1Size; i++) {
            cards1[i] = scanner.nextLine();
        }
        for (int i = 0; i < cards2Size; i++) {
            cards2[i] = scanner.nextLine();
        }
        for (int i = 0; i < goal.length; i++) {
            goal[i] = scanner.nextLine();
        }

        String result = solution(cards1, cards2, goal);
        System.out.println(result);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        ArrayDeque<String> cards1Deque = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cards2Deque = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        while (!goalDeque.isEmpty()) {

            String goalData = goalDeque.pollFirst();

            if (!cards1Deque.isEmpty() && goalData.equals(cards1Deque.peek())) {
                cards1Deque.pollFirst();
            } else if (!cards2Deque.isEmpty() && goalData.equals(cards2Deque.peek())) {
                cards2Deque.pollFirst();
            } else {
                break;
            }
        }
        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}

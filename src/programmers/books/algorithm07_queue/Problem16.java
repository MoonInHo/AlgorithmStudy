package programmers.books.algorithm07_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem16 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();

        int[] progresses = new int[arraySize];
        int[] speeds = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            progresses[i] = scanner.nextInt();
        }
        for (int i = 0; i < arraySize; i++) {
            speeds[i] = scanner.nextInt();
        }

        int[] result = solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayDeque<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;

        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0;
        int maxDay = daysLeft[0];

        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

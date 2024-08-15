package algorithm16_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem80 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int peopleLength = scanner.nextInt();
        int[] people = new int[peopleLength];

        for (int i = 0; i < peopleLength; i++) {
            people[i] = scanner.nextInt();
        }

        int limit = scanner.nextInt();

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {

        Arrays.sort(people);

        int count = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i += 1;
            }
            j -= 1;
            count += 1;
        }
        return count;
    }
}

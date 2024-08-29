package programmers.books.algorithm13_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Problem54 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int commandsLength = scanner.nextInt();
        int[][] commands = new int[commandsLength][3];

        for (int i = 0; i < commandsLength; i++) {
            for (int j = 0; j < 3; j++) {
                commands[i][j] = scanner.nextInt();
            }
        }
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int c = 0; c < commands.length; c++) {

            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            int[] slicedArr = Arrays.copyOfRange(array, i - 1, j);

            Arrays.sort(slicedArr);

            answer[c] = slicedArr[k - 1];
        }
        return answer;
    }
}

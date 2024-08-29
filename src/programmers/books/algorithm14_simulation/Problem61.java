package programmers.books.algorithm14_simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Problem61 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] result = solution(n);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] solution(int n) {

        int[][] snailArray = new int[n][n];
        int num = 1;

        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                snailArray[startRow][i] = num++;
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                snailArray[i][endCol] = num++;
            }
            endCol--;

            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    snailArray[endRow][i] = num++;
                }
                endRow--;
            }

            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    snailArray[i][startCol] = num++;
                }
                startCol++;
            }
        }
        return snailArray;
    }
}

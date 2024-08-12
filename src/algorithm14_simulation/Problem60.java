package algorithm14_simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Problem60 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        int[][] result = solution(matrix1, matrix2);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {

        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private static int[][] transposeMatrix(int[][] matrix) {

        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] solution(int[][] matrix1, int[][] matrix2) {

        int[][] multiplied = multiplyMatrices(matrix1, matrix2);

        return transposeMatrix(multiplied);
    }
}
